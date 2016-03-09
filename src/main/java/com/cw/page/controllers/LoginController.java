package com.cw.page.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage(Principal loginChecker) {

		ModelAndView model = new ModelAndView();
		if (loginChecker != null) {
			model.addObject("title", "Database management site for admins:");
			model.setViewName("admin");
		} else {
			ModelAndView notLoggedIn = new ModelAndView("redirect:/");
			return notLoggedIn;
		}
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
}
