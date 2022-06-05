<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-info">
			<div><a href="user-list.jsp" class="navbar-brand"> ADMINISTRAR  ESTUDIANTES </a>
			</div>

			


			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listUser"
					class="nav-link">VER ESTUDIANTES</a></li>
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link">INSERTAR ESTUDIANTES</a></li>
						<li><a href="<%=request.getContextPath()%>/notas"
					class="nav-link">VER NOTAS</a></li>
												<li><a href="<%=request.getContextPath()%>/newnotas"
					class="nav-link">INSERTAR NOTAS</a></li>

			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success"
*ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">LISTA DE NOTAS</h3>
			<hr>

			
						<div  style=" display: flex ;     align-items: center;   flex-direction:  row; ">
						<div class="container text-left">

			<a href="<%=request.getContextPath()%>/listUser"
					class="btn btn-info">VER ESTUDIANTES</a>
			</div>
			<div  class="container text-left">

				<a href="<%=request.getContextPath()%>/newnotas" class="btn btn-info">NUEVA NOTA
					</a>
			</div>
			
			</div>
			
			
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID ESTUDIANTE</th>
						<th>NOTA1</th>
						<th>NOTA2</th>
						<th>NOTA3</th>
						<th>PROMEDIO</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
					<!--	for (Todo todo: todos) { -->
					<c:forEach var="nota" items="${listNotas}">

 









						<tr>


							<td><c:out value="${nota.id_estudiante}" /></td>

							<td><c:out value="${nota.nota1}" /></td>

							<td><c:out value="${nota.nota2}" /></td>

							<td><c:out value="${nota.nota3 }" /></td>
							
							<td><c:out value="${nota.promedio }" /></td>


                            <td><a href="editNotas?id_estudiante=<c:out value='${nota.id_estudiante}' />">EDITAR</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteNotas?id_estudiante=<c:out
 
value='${nota.id_estudiante}' />">ELIMINAR</a></td>
							

						

							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>




				
</body>

</html>

