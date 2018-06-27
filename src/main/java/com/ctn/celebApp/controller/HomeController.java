package com.ctn.celebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HomeController
{
	@RequestMapping(value = "/")
	public String login() {
	return "index";
	}
}