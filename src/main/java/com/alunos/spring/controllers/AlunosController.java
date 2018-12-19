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
import com.alunos.spring.model.TelefoneTipo;

@Controller
public class AlunosController
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
	
	@GetMapping(value = "/matricular")
	public String matricular(Locale locale, Model model)
	{
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        
		return "matricular";
	}
	
	@PostMapping(value = "/matricular")
	public String confirmarMatricula(Locale locale, @ModelAttribute("aluno") Aluno a, BindingResult result, SessionStatus status)
	{
		a.getTelefones().get(0).setTipo(TelefoneTipo.CELULAR);
		a.getTelefones().get(1).setTipo(TelefoneTipo.RESIDENCIAL);
		
		alunosManager.matricular(a);
		
		return "redirect:/alunosLista";
	}	

	@GetMapping(value = "/alunosLista")
	public ModelAndView getdata()
	{
		List<Aluno> alunos = alunosManager.getAlunos();

		// return back to index.jsp
		ModelAndView model = new ModelAndView("alunosLista");
		model.addObject("alunos", alunos);

		return model;
	}
}