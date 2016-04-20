package com.cw.page.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cw.database.cars.Car;
import com.cw.database.cars.CarDAO;
import com.cw.database.news.News;
import com.cw.database.news.NewsDAO;
import com.cw.database.services.Service;
import com.cw.database.services.ServiceDAO;

@Controller
public class AddItemController {

	@Autowired
	CarDAO carDAO;
	@Autowired
	ServiceDAO serviceDAO;
	@Autowired
	NewsDAO newsDAO;

	@RequestMapping(value = "/admin/addCar", method = RequestMethod.GET)
	public ModelAndView addCar() {
		return new ModelAndView("addCar", "command", new Car());
	}

	@ModelAttribute(value = "list_news")
	public List<News> getNewsList() {
		return newsDAO.findAll();

	}

	@ModelAttribute(value = "list_cars")
	public List<Car> getCarList() {
		return carDAO.findAll();

	}

	@ModelAttribute(value = "list_services")
	public List<Service> getServiceList() {
		return serviceDAO.findAll();

	}

	@RequestMapping(value = "/admin/list_items", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("SpringWeb") Car car, ModelMap model) {

		carDAO.saveNewCar(car);
		newsDAO.findAll();
		serviceDAO.findAll();
		// model.addAttribute("list", carDAO.findAll());

		return "list_items";

	}
}
