package com.cw.page.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cw.database.cars.CarDAO;
import com.cw.database.news.NewsDAO;
import com.cw.database.services.ServiceDAO;

@Controller
public class ListItemsController {
	
	@Autowired
	CarDAO carDAO;
	@Autowired
	NewsDAO newsDAO;
	@Autowired
	ServiceDAO serviceDAO;
	
	   @RequestMapping(value = {"/admin/list","/admin/list_items"}, method = RequestMethod.GET)
	   public String list(Principal loginChecker, ModelMap model) {
			if (loginChecker != null) {
				model.addAttribute("list_cars", carDAO.findAll());
				model.addAttribute("list_services", serviceDAO.findAll());
				model.addAttribute("list_news", newsDAO.findAll());
				return "list_items";
			} else {
				return "redirect:/";
			}
	   }
}
