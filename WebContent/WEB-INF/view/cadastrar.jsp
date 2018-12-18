<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
    <title>Novo aluno</title>
</head>
 
 
 
<body>
    <h2>Cadastro de aluno</h2>
    <br/>
    <form:form method="post" action="submit" modelAttribute="aluno">
        <table>
            <tr>
                <td>Nome</td>
                <td><form:input path="nome" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Cadastrar"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>