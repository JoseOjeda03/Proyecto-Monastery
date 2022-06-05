<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-info">




		

			<div><a href="user-list.jsp" class="navbar-brand">	ADMINISTRAR ESTUDIANTES </a>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${nota != null}">
					<form action="updateNotas" method="post">
				</c:if>
				<c:if test="${nota == null}">
					<form action="insertNotas" method="post">
				</c:if>

				<caption>
				
					<h2>
						<c:if test="${nota != null}">
						EDITAR NOTAS
						</c:if>
						<c:if test="${nota == null}"> 
						INSERTAR NUEVA NOTAS
						</c:if>
					</h2>
				</caption>
<c:if test="${nota != null}">
					<input type="hidden" name="id_estudiante"
						value="<c:out



				value='${nota.id_estudiante}' />"  /> 

				

</c:if>

<fieldset class="form-group">
<label>NOTA1</label> <input type="text" value="<c:out value='${nota.nota1}' />"
class="form-control" name="nota1" required="required">
 
</fieldset>

<fieldset class="form-group">
<label>NOTA2</label> <input type="text"
 
value="<c:out value='${nota.nota2}' />" 
 

class="form-control"name="nota2">
 



</fieldset>

 <fieldset class="form-group">
						<label>NOTA3</label> <input type="text"
							value="<c:out value='${nota.nota3}' />" 

	class="form-control"	name="nota3">

 </fieldset>
 <c:if test="${nota == null}">
 <fieldset class="form-group">
						<label>ID ESTUDIANTE</label> <input type="text"
							value="<c:out value='${nota.id_estudiante}' />" 

	class="form-control"	name="id_estudiante">

 </fieldset>
</c:if>
 <button type="submit" class="btn btn-info">Save</button>
				</form>
			</div>
			</div>
		</div>
</body>

</html>

