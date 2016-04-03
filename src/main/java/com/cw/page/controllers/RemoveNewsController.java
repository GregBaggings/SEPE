package com.cw.page.controllers;

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
public class RemoveNewsController {

	@Autowired
	NewsDAO newsDAO;
	
	@RequestMapping(value = "/admin/removeNews", method = RequestMethod.GET)
	public ModelAndView removeCar() {
		return new ModelAndView("removeNews", "command", new News());
	}

	@RequestMapping(value = "/admin/deleteNews", method = RequestMethod.POST)
	public String removeCar(@ModelAttribute("SpringWeb") News news, ModelMap model){

		model.addAttribute("newsID", news.getNewsId());

		newsDAO.deleteNews(news.getNewsId());
		return "admin";	
	}
}
