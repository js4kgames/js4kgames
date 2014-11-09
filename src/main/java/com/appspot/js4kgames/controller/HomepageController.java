package com.appspot.js4kgames.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to show the js4kgames home page.
 * 
 * @author js4kgames
 */
@Controller
@RequestMapping("/")
public class HomepageController extends AbstractController {

	/**
	 * Displays the home page.
	 * 
	 * @param request
	 * @param model
	 * 
	 * @return
	 */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showHomepage(HttpServletRequest request, Model model){
        model.addAttribute("menuSelection", "home");
        return "home";
    }
}
