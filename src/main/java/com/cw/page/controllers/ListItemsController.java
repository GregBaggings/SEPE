package com.cw.page.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListItemsController {
	   @RequestMapping(value = "/admin/list", method = RequestMethod.GET)
	   public ModelAndView contactPage(Principal loginChecker) {
		   ModelAndView model = new ModelAndView();
			if (loginChecker != null) {
				model.setViewName("list_items");
			} else {
				ModelAndView notLoggedIn = new ModelAndView("redirect:/");
				return notLoggedIn;
			}
			return model;
	   }
}
