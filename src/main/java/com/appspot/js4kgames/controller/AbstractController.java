package com.appspot.js4kgames.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.appspot.js4kgames.model.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Base controller class, containing features common to all pages.
 * 
 * @author js4kgames
 */
public abstract class AbstractController {

    /**
     * Constant for the key used for storing the user profile in the session.
     */
    private static final String USER_SESSION_KEY = "js4kgames-user-profile";

    /**
     * Adds the login URL to the model but only if the user is logged out.
     * 
     * @param request The current HTTP request.
     * 
     * @return The login URL, or null if the user is already logged in.
     */
    @ModelAttribute("loginUrl")
    public String getLoginUrl(HttpServletRequest request) {
        UserService userService = UserServiceFactory.getUserService();
        return (userService.isUserLoggedIn()? null : userService.createLoginURL(request.getRequestURI()));
    }
    
    /**
     * Adds the logout URL to the model but only if the user is logged in.
     * 
     * @param request The current HTTP request.
     * 
     * @return The logout URL, or null if the user is already logged out.
     */
    @ModelAttribute("logoutUrl")
    public String getLogoutUrl(HttpServletRequest request) {
        UserService userService = UserServiceFactory.getUserService();
        return (userService.isUserLoggedIn()? userService.createLogoutURL(request.getRequestURI()) : null);
    }
    
    /**
     * Gets the user profile for current user.
     * 
     * @param request The current HTTP request.
     * 
     * @return The user profile for the current user.
     */
    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        UserService userService = UserServiceFactory.getUserService();
        com.google.appengine.api.users.User googleUser = userService.getCurrentUser();
        
        User user = (User) request.getSession(true).getAttribute(USER_SESSION_KEY);
        
        if (user == null) {
            // TODO: Start by checking the user guid cookie.
            
            // TODO: If there isn't a user guid, generate a new one.
            
            // TODO: Load the user from the data store at this point. For now we'll just create a new one.
            
            user = new User();
        }

        user.setLoggedIn(userService.isUserLoggedIn());
        
        if (googleUser != null) {
            // User is logged in. Gets some details off the Google Account.
            user.setEmailAddress(googleUser.getEmail());
            user.setId(googleUser.getUserId());
            user.setNickName(googleUser.getNickname());
            user.setAdmin(userService.isUserAdmin());
        } else {
            user.setAdmin(false);
        }
        
        // TODO: Update user profile to data store.
        
        request.getSession().setAttribute(USER_SESSION_KEY, user);
        
        return user;
    }

}
