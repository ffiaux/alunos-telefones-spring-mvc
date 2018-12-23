<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
    <title>Novo aluno</title>
    
	<link href="resources/js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css">
	<link href="resources/js/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css">
	<link href="resources/js/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css">
	
	<link href="resources/css/bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="resources/css/bootstrap-4.1.3-dist/css/bootstrap-grid.css" rel="stylesheet" type="text/css">	
	
	<script type="text/javascript" src='resources/js/jquery-3.3.1.min.js'></script>
	<script type="text/javascript" src='resources/js/jquery-ui-1.12.1/jquery-ui.min.js'></script>  
	<script type="text/javascript" src='resources/css/bootstrap-4.1.3-dist/js/bootstrap.min.js'></script>
    
    <!-- https://jqueryui.com/datepicker/ -->
	<script>
		$(function() 
		{
			$("#dataNascimento").datepicker();
		});
	</script>    
</head>
 
<body>
	<!-- https://getbootstrap.com/docs/4.1/components/forms/ -->
	<div class="card">
	    <h2>Cadastro de aluno</h2>
	
		<div class="card-body">
			<spr:form method="post" action="matricular" modelAttribute="aluno">
				<div class="form-group">
					<label for="nome">Nome</label>
					<spr:input path="nome" cssClass="form-control" />
					<spr:errors path="nome" cssClass="error" />
				</div>
				
				<div class="form-group">
					<label for="dataNascimento">Data Nascimento</label>
					<input type="text" id="dataNascimento" name="dataNascimento" class="form-control" />
				</div>
				
				<div class="form-group">
					<label id="telefoneCelular">Telefone Celular</label>
					<spr:input id="telefoneCelular" path="telefones[0].numero" cssClass="form-control" />
				</div>
				
				<div class="form-group">
					<label for="telefoneResidencial">Telefone Residencial</label>
					<spr:input id="telefoneResidencial" path="telefones[1].numero" cssClass="form-control" />
				</div>  
				
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</spr:form>  
		</div>
	</div>

    
</body>
</html>