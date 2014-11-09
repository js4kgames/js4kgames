package com.appspot.js4kgames.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to show the js4kgames games page.
 * 
 * @author js4kgames
 */
@Controller
public class GamesController extends AbstractController {

    /**
     * Displays the games page.
     * 
     * @param request
     * @param model
     * 
     * @return
     */
    @RequestMapping(value="/games", method=RequestMethod.GET)
    public String showGamesPage(HttpServletRequest request, Model model) {
        return "games";
    }
}
