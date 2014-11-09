package com.appspot.js4kgames.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to show the js4kgames submit page.
 * 
 * @author js4kgames
 */
@Controller
public class SubmitController extends AbstractController {
    
    /**
     * Displays the submit page.
     * 
     * @param request
     * @param model
     * 
     * @return
     */
    @RequestMapping(value="/submit", method=RequestMethod.GET)
    public String showSubmitPage(HttpServletRequest request, Model model) {
        return "submit";
    }
}
