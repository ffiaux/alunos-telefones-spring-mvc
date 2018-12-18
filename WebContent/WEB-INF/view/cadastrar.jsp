<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
    <title>Novo aluno</title>
</head>
 
<body>
    <h2>Cadastro de aluno</h2>
    <br/>
    <spr:form method="post" action="submit" modelAttribute="aluno">
        <table>
            <tr>
                <td>Nome</td>
                <td><spr:input path="nome" /></td>
            </tr>
            <tr>
            
                <td colspan="2"><input type="submit" value="Cadastrar"/></td>
            </tr>
        </table>
    </spr:form>
</body>
</html>