package com.cw.page.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.database.cars.CarDAO;
import com.cw.database.news.NewsDAO;
import com.cw.database.services.Service;
import com.cw.database.services.ServiceDAO;

@Controller
public class AddServiceController {

	@Autowired
	CarDAO carDAO;
	@Autowired
	ServiceDAO serviceDAO;
	@Autowired
	NewsDAO newsDAO;

	@RequestMapping(value = "/admin/addService", method = RequestMethod.GET)
	public ModelAndView addService(Principal loginChecker) {
		if (loginChecker != null) {
			return new ModelAndView("addService", "command", new Service());
		} else {
			ModelAndView notLoggedIn = new ModelAndView("redirect:/");
			return notLoggedIn;
		}
	}

	@RequestMapping(value = "/admin/list", method = RequestMethod.POST)
	public String addService(Principal loginChecker, @ModelAttribute("SpringWeb") Service service, ModelMap model) {
		if (loginChecker != null) {
			serviceDAO.saveNewService(service);
			model.addAttribute("list_cars", carDAO.findAll());
			model.addAttribute("list_services", serviceDAO.findAll());
			model.addAttribute("list_news", newsDAO.findAll());
			return "list_items";
		} else {
			return "redirect:/";
		}
	}
}
