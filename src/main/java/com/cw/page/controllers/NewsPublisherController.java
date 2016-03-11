package com.cw.page.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.newspublisher.NewsArticle;
import com.cw.newspublisher.NewsDAO;

@Controller
public class NewsPublisherController {

	@RequestMapping(value = "/addNews", method = RequestMethod.GET)
	public ModelAndView addNews() {
		return new ModelAndView("addNews", "command", new NewsArticle());
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("SpringWeb") NewsArticle news, ModelMap model){

		@SuppressWarnings("resource")
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");
		
		model.addAttribute("newId", news.getNewsId());
		model.addAttribute("date", news.getDate());
		model.addAttribute("title", news.getTitle());
		model.addAttribute("content", news.getContent());

		newsDAO.createNews(news);

		return "index";	
	}
}
