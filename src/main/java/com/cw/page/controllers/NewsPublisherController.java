package com.cw.page.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.database.news.News;
import com.cw.database.news.NewsDAO;

@Controller
public class NewsPublisherController {
	@Autowired
	NewsDAO newsDAO;

	@RequestMapping(value = "/admin/addNews", method = RequestMethod.GET)
	public ModelAndView addNews(Principal loginChecker) {
		if (loginChecker != null) {
			return new ModelAndView("addNews", "command", new News());
		} else {
			ModelAndView notLoggedIn = new ModelAndView("redirect:/");
			return notLoggedIn;
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addNews(Principal loginChecker, @ModelAttribute("SpringWeb") News news, ModelMap model) {
		if (loginChecker != null) {
			model.addAttribute("newId", news.getNewsId());
			model.addAttribute("date", news.getDate());
			model.addAttribute("title", news.getTitle());
			model.addAttribute("content", news.getContent());

			newsDAO.createNews(news);

			return "admin";
		} else {
			return "redirect:/";
		}
	}
}
