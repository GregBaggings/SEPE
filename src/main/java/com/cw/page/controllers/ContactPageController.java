package com.cw.page.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactPageController {
	
	   @RequestMapping(value = "/contact", method = RequestMethod.GET)
	   public String contactPage() {
	      return "contact";
	   }
}
