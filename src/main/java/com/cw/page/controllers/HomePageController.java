package com.cw.page.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cw.database.news.NewsDAO;

@Controller
public class HomePageController {
	
	@Autowired
	NewsDAO newsDAO;
	
	   @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	   public String homePage(ModelMap model) {
		   model.addAttribute("news_list", newsDAO.findTop5ByOrderByDateDesc());
	      return "index";
	   }
}
