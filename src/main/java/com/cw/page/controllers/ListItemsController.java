package com.cw.page.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cw.database.model.CarDAO;

@Controller
public class ListItemsController {
	
	@Autowired
	CarDAO carDAO;
	
	   @RequestMapping(value = {"/admin/list","/admin/list_items"}, method = RequestMethod.GET)
	   public String list(Principal loginChecker, ModelMap model) {
			if (loginChecker != null) {
				model.addAttribute("list", carDAO.findAll());
				return "list_items";
			} else {

				return "redirect:/";
			}
	   }
}
