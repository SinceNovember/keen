package com.liu.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="test")
	public String test(Model model){
		System.out.println("test:"+userService.getAllUser());
		model.addAttribute("test", userService.getAllUser());
		System.out.println("test");
		return "test";
	}
}
