package com.alunos.spring.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alunos.spring.manager.AlunosManager;
import com.alunos.spring.model.Aluno;
import com.alunos.spring.model.Documento;
import com.alunos.spring.model.TelefoneTipo;
import com.alunos.spring.util.MatriculaUtil;

@Controller
public class AlunosController
{
	@Autowired
	private AlunosManager alunosManager;
	
	@Autowired
	ServletContext servletContext;
	
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
	
	@GetMapping(value = "/cadastrarDocumento")
	public String cadastrarDocumento(Locale locale, Model model, @RequestParam("idAluno") Integer idAluno)
	{
		Documento doc = new Documento();
        model.addAttribute("doc", doc);
        model.addAttribute("aluno", this.alunosManager.getAluno(idAluno));
                
		return "cadastrarDocumento";
	}
	
	@PostMapping(value = "/cadastrarDocumento")
	public String cadastrarDocumento(Locale locale, @ModelAttribute("doc") Documento doc, @RequestParam("idAluno") Integer idAluno, BindingResult result, SessionStatus status, @RequestParam("fileDocumento") MultipartFile file) throws IOException
	{
		uploadFile(file, alunosManager.getAluno(idAluno), doc);
		
		return "redirect:/alunosLista";
	}
	
	@GetMapping(value = "/downloadDocumento")
	public void downloadDocumento(Locale locale, Model model, @RequestParam("idDoc") Integer idDocumento, HttpServletResponse response) throws IOException
	{
		Documento doc = alunosManager.getDocumento(idDocumento);
		File f = new File(doc.getNomePasta() + doc.getNomeArquivo());
		InputStream is = new FileInputStream(f);
		IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}	
	
	private void uploadFile(MultipartFile file, Aluno a, Documento d) throws IOException
	{
		//Salvar o cliente no banco para gerar o id
		Integer idAluno = a.getId();
		String raiz = servletContext.getRealPath("/");
		
		//Gerar o diretorio do cliente com 0s a esquerda
		String diretorioCliente = MatriculaUtil.left(idAluno);
				
		//Criar o diretorio e o arquivo
		String caminhoCompleto = raiz + diretorioCliente + "\\";
		new File(caminhoCompleto).mkdir();		
		new File(caminhoCompleto, file.getOriginalFilename()).createNewFile();
				
		//Leio os bytes da origem
		byte[] bytes = file.getBytes();
		
		//Obtenho o arquivo de destino
		Path path = Paths.get(caminhoCompleto + file.getOriginalFilename());
		
		//Gravo no arquivo de destino os bytes de origem
		Files.write(path, bytes);
		
		d.setNomeArquivo(file.getOriginalFilename());
		d.setNomePasta(caminhoCompleto);
		d.setDataUpload(new Date());
		d.setAluno(a);
		alunosManager.uploadDocumento(d);
	}	
	
	@GetMapping(value = "/alunosLista")
	public ModelAndView getData()
	{
		List<Aluno> alunos = alunosManager.getAlunos();
		ModelAndView model = new ModelAndView("alunosLista");
		model.addObject("alunos", alunos);

		return model;
	}
}