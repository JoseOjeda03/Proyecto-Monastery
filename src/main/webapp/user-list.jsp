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
			<h3 class="text-center">LISTA DE ESTUDIANTES</h3>
			<hr>
			<div  style=" display: flex ;     align-items: center;   flex-direction:  row; ">
						<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-info">INSERTAR
					NUEVO USUARIO</a>
			</div>
			<div  class="container text-left">

				<a href="<%=request.getContextPath()%>/notas" class="btn btn-info">NOTAS
					</a>
			</div>
			
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>CURSO</th>
						<th>AÑOS</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
					<!--	for (Todo todo: todos) { -->
					<c:forEach var="user" items="${listUser}">

 









						<tr>


							<td><c:out value="${user.id}" /></td>

							<td><c:out value="${user.name}" /></td>

							<td><c:out value="${user.curso}" /></td>

							<td><c:out value="${user.año}" /></td>


                            <td><a href="edit?id=<c:out value='${user.id}' />">EDITAR</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out
 
value='${user.id}' />">ELIMINAR</a></td>
							

						

							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>




				
</body>

</html>

