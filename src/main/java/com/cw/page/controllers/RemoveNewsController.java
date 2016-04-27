package com.cw.page.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.database.cars.CarDAO;
import com.cw.database.news.News;
import com.cw.database.news.NewsDAO;
import com.cw.database.services.ServiceDAO;

@Controller
public class RemoveNewsController {

	@Autowired
	CarDAO carDAO;
	@Autowired
	NewsDAO newsDAO;
	@Autowired
	ServiceDAO serviceDAO;

	@RequestMapping(value = "/admin/removeNews", method = RequestMethod.GET)
	public ModelAndView removeCar(Principal loginChecker) {
		if (loginChecker != null) {
			return new ModelAndView("removeNews", "command", new News());
		} else {
			ModelAndView notLoggedIn = new ModelAndView("redirect:/");
			return notLoggedIn;
		}
	}

	@RequestMapping(value = "/admin/deleteNews", method = RequestMethod.POST)
	public String removeCar(Principal loginChecker, @ModelAttribute("SpringWeb") News news, ModelMap model) {
		if (loginChecker != null) {
			
			model.addAttribute("newsID", news.getNewsId());
			try {
			newsDAO.deleteNews(news.getNewsId());
			} catch (EmptyResultDataAccessException e) {

			}model.addAttribute("list_cars", carDAO.findAll());
			model.addAttribute("list_services", serviceDAO.findAll());
			model.addAttribute("list_news", newsDAO.findAll());
			return "list_items";
		} else {
			return "redirect:/";
		}
	}
}
