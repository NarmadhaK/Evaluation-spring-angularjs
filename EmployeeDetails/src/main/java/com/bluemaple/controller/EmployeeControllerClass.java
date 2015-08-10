package com.bluemaple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.dto.GetEmployeeDetails;
import com.bluemaple.service.EmployeeServiceInterface;

@Controller
@RequestMapping(value = "/mapp")
public class EmployeeControllerClass {
	@Autowired
	private EmployeeServiceInterface interfface;

	public EmployeeServiceInterface getInterfface() {
		return interfface;
	}

	public void setInterfface(EmployeeServiceInterface interfface) {
		this.interfface = interfface;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getdetail(@ModelAttribute GetEmployeeDetails user) {
		System.out.println("hai this is registration controller");
		user=interfface.doRegistration(user);
		return "Registration";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		GetEmployeeDetails user=interfface.doLogin(username, password);
		System.out.println("user value"+user);
		return null;
    }
   }
