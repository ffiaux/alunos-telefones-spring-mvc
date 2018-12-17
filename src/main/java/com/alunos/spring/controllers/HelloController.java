package com.alunos.spring.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController
{
	@GetMapping(value = "/")
	public String index(Locale locale, Model model)
	{
		return "index";
	}	
	
	@GetMapping(value = "/hello")
	public String hello(Locale locale, Model model)
	{
		return "hello";
	}
}
