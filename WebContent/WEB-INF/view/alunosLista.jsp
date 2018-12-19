<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Lista de alunos</h2>

	<c:if test="${not empty alunos}">

		<ul>
			<c:forEach var="a" items="${alunos}">
				<li>
					${a.nome} - 
					<c:if test="${a.matricula == null}">Aluno sem matricula</c:if> 
					<c:if test="${a.matricula != null}">${a.matricula.codigo}</li></c:if>								
				<ul>				
					<c:if test="${empty a.telefones}">
						<li>Nenhum telefone encontrado</li>	
					</c:if>
					
					<c:forEach var="t" items="${a.telefones}">
						<li>${t.numero}</li>
					</c:forEach>
				</ul>
			</c:forEach>
		</ul>

	</c:if>
	
	<p>Clique <a href='matricular'>aqui</a> para cadastrar alunos</p>
</body>
</html>