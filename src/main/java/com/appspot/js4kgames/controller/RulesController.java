package com.appspot.js4kgames.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to show the js4kgames rules page.
 * 
 * @author js4kgames
 */
@Controller
public class RulesController extends AbstractController {

    /**
     * Displays the rules page.
     * 
     * @param request
     * @param model
     * 
     * @return
     */
    @RequestMapping(value="/rules", method=RequestMethod.GET)
    public String showRulesPage(HttpServletRequest request, Model model) {
        return "rules";
    }
}
