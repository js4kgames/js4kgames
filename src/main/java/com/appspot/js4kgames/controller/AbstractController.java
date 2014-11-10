package com.appspot.js4kgames.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.appspot.js4kgames.dao.UserDao;
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

    // ---------------------- All controllers have access to all of the DAOs ----------------------- 
    
    protected UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

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
     * @return The user profile for the current user, or null if their not logged in.
     */
    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        User user = null;
        
        UserService userService = UserServiceFactory.getUserService();
        
        if (userService.isUserLoggedIn()) {
            user = (User) request.getSession(true).getAttribute(USER_SESSION_KEY);
            
            if (user == null) {
                com.google.appengine.api.users.User googleUser = userService.getCurrentUser();
                
                // Attempt to find the user in the data store.
                user = userDao.find(googleUser.getUserId());
                
                // If we didn't find this user, create a new one.
                if (user == null) {
                    user = new User();
                }
                
                // Update user details from the Google Account.
                user.setEmailAddress(googleUser.getEmail());
                user.setId(googleUser.getUserId());
                user.setNickName(googleUser.getNickname());
                user.setAdmin(userService.isUserAdmin());
                user.setLoginCount(user.getLoginCount() + 1);
                user.setLastLogin(new Date());
                
                userDao.save(user);
                
                request.getSession().setAttribute(USER_SESSION_KEY, user);
            }
        } else {
            // User is not logged in, so remove the User from the session if it is still there.
            request.getSession().removeAttribute(USER_SESSION_KEY);
        }
        
        return user;
    }

}
