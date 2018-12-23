<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sistema de alunos</title>
	
	<link href="resources/js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css">
	<link href="resources/js/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css">
	<link href="resources/js/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src='resources/js/jquery-3.3.1.min.js'></script>
	<script type="text/javascript" src='resources/js/jquery-ui-1.12.1/jquery-ui.min.js'></script>

	<!-- https://jqueryui.com/dialog/ -->
	<script>
		$( function() 
		{
			$( "#dialog" ).dialog();
		} );
	</script>

</head>
<body>	
	<!-- https://jqueryui.com/dialog/ -->
	<div id="dialog" title="Basic dialog">
	 	<p>
			Bem vindo ao sistema de alunos, clique <a href='alunosLista'>aqui</a> para gerenciar alunos	 	
	 	</p>
	</div>	
</body>
</html>