<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastrar Documento</title>
	</head>
<body>
	<h2>Cadastro de Documento para o aluno ${aluno.nome}</h2>
	
	<br />
	<spr:form method="post" enctype="multipart/form-data" action="cadastrarDocumento" modelAttribute="doc">
		<input type="hidden" name="idAluno" value="${aluno.id}"/>
		
		<table>
			<tr>
				<td>Arquivo</td>
				<td>
					<input type="file" name="fileDocumento" />
				</td>
			</tr>
			
            <tr>
                <td>Tipo</td>
                <td>
                	<spr:select path="tipo">
                		<spr:option value="RG">RG</spr:option>
                		<spr:option value="CPF">CPF</spr:option>
                		<spr:option value="CERTIDAO_NASCIMENTO">Certidao de Nascimento</spr:option>
                		<spr:option value="DIPLOMA">Diploma</spr:option>
                		<spr:option value="CERTIFICADO">Certificado</spr:option>
                	</spr:select>
                </td>
            </tr>            		
			
			<tr>	
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>
		</table>
	</spr:form>
</body>
</html>