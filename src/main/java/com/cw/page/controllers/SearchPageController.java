package com.cw.page.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.database.model.CarDAO;
import com.cw.search.SearchObject;

@Controller
public class SearchPageController {
	
	@Autowired
	CarDAO carDAO;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search() {
		return new ModelAndView("search", "command", new SearchObject());
	}

	@RequestMapping(value = "/searchResult", method = RequestMethod.POST)
	public String searchItem(@ModelAttribute("SpringWeb") SearchObject searchItem, ModelMap model) {

		model.addAttribute("list", carDAO.findByName(searchItem.getsearchKey()));

		return "searchResult";
	}
}
