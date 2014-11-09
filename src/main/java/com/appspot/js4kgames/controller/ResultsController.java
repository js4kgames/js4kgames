package com.appspot.js4kgames.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to show the js4kgames results page.
 * 
 * @author js4kgames
 */
@Controller
public class ResultsController extends AbstractController {

    /**
     * Displays the game results page.
     * 
     * @param request
     * @param model
     * 
     * @return
     */
    @RequestMapping(value="/results", method=RequestMethod.GET)
    public String showResultsPage(HttpServletRequest request, Model model) {
        return "results";
    }
}
