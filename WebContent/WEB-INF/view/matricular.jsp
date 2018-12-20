<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
    <title>Novo aluno</title>
</head>
 
<body>
    <h2>Cadastro de aluno</h2>
    <br/>
    <spr:form method="post" action="matricular" modelAttribute="aluno">
        <table>
            <tr>
                <td>Nome</td>
                <td>
                	<spr:input path="nome" />
                	<spr:errors path="nome" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Telefone Celular</td>
                <td><spr:input path="telefones[0].numero" /></td>
            </tr>
            <tr>
                <td>Telefone Residencial</td>
                <td><spr:input path="telefones[1].numero" /></td>
            </tr>            
            <tr>            
                <td colspan="2"><input type="submit" value="Cadastrar"/></td>
            </tr>
        </table>
    </spr:form>
</body>
</html>