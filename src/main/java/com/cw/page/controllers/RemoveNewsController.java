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

import com.cw.database.news.News;
import com.cw.database.news.NewsDAO;

@Controller
public class RemoveNewsController {

	@Autowired
	NewsDAO newsDAO;

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

			}
			return "admin";
		} else {
			return "redirect:/";
		}
	}
}
