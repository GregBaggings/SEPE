package com.cw.page.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class RemoveServiceController {

	@Autowired
	CarDAO carDAO;
	@Autowired
	NewsDAO newsDAO;
	@Autowired
	ServiceDAO serviceDAO;

	@RequestMapping(value = "/admin/removeService", method = RequestMethod.GET)
	public ModelAndView removeCar() {
		return new ModelAndView("removeService", "command", new Service());
	}

	@RequestMapping(value = "/admin/list_items_after_delete_service", method = RequestMethod.POST)
	public String removeCar(@ModelAttribute("SpringWeb") Service service, ModelMap model) {

		model.addAttribute("serviceId", service.getServiceId());
		try {
			serviceDAO.deleteService(service.getServiceId());
		} catch (EmptyResultDataAccessException e) {

		}
		model.addAttribute("list_cars", carDAO.findAll());
		model.addAttribute("list_services", serviceDAO.findAll());
		model.addAttribute("list_news", newsDAO.findAll());
		return "list_items";
	}
}
