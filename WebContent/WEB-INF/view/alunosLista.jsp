<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Lista de alunos</h2>

	<c:if test="${not empty alunos}">
		<table border="1">
			<thead>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Tel. Residencial</th>
				<th>Tel. Celular</th>
				<th>Documentos</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach var="a" items="${alunos}">
					<tr>
						<td>
							${a.nome}
						</td>
						
						<td>
							<c:if test="${a.matricula == null}">Aluno sem matricula</c:if>
							<c:if test="${a.matricula != null}">${a.matricula.codigo}</c:if>
						</td>
						
						<td>
							<c:if test="${empty a.telefones}">
								<li>Nenhum telefone encontrado</li>	
							</c:if>
							
							${a.telefones[0].numero}
						</td>
						<td>
							<c:if test="${empty a.telefones}">
								<li>Nenhum telefone encontrado</li>	
							</c:if>		
							
							${a.telefones[1].numero}
						</td>
						<td>
							<ul>
								<c:forEach var="doc" items="${a.documentos}">
									<li><a target="_blank" href='downloadDocumento?idDoc=${doc.id}'>${doc.nomeArquivo}</a></li>
								</c:forEach>
							</ul>
						</td>
						<td>
							<a href='cadastrarDocumento?idAluno=${a.id}'>Novo Doc.</a>
						</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<p>Clique <a href='matricular'>aqui</a> para cadastrar alunos</p>
</body>
</html>