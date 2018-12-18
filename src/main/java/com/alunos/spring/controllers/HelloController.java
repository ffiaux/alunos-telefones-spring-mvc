package com.alunos.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.alunos.spring.manager.AlunosManager;
import com.alunos.spring.model.Aluno;

@Controller
public class HelloController
{
	@Autowired
	private AlunosManager alunosManager;
	
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
	
	@GetMapping(value = "/cadastrar")
	public String cadastrar(Locale locale, Model model)
	{
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        
		return "cadastrar";
	}
	
	@PostMapping(value = "/submit")
	public String submit(Locale locale, @ModelAttribute("aluno") Aluno a, BindingResult result, SessionStatus status)
	{
		System.out.println(a.getNome());
		
		return "list";
	}	

	@GetMapping(value = "/list")
	public ModelAndView getdata()
	{
		List<String> list = getList();

		// return back to index.jsp
		ModelAndView model = new ModelAndView("list");
		model.addObject("lists", list);

		return model;
	}

	private List<String> getList()
	{
		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;
	}
}
