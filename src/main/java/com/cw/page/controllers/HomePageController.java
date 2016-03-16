package com.cw.page.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	private final Logger logger = LoggerFactory.getLogger(HomePageController.class);

	   @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	   public String homePage() {
		  logger.debug("Homepage loaded."); //logger test
	      return "index";
	   }
}
