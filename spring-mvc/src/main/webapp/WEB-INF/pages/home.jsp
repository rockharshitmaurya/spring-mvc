<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<div class="container mt-3">
		<h1 class="text-center">Welcome to TODO Manager</h1>
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
				<b><c:out value="${msg}"></c:out></b>
			</div>
		</c:if>

		<div class="row mt-5">
			<div class="col-md-2">
				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active">
						Menu</button>
					<a href='<c:url value="/add"/>'
						class="list-group-item list-group-item-action">Add TODO</a>
					<a href='<c:url value="/home"/>'
						class="list-group-item list-group-item-action">View TODO
					</a>
				</div>
			</div>
			<div class="col-md-10">
				<%-- 	<c:out value="${page}" /> --%>
				<c:if test="${page=='home'}">
					<h1 class="text-center">All TODOs</h1>
					<table>
						<tr>
							<th>Title</th>
							<th>Content</th>
						</tr>
						<c:forEach var="todoItem" items="${all_data}">
							<td>${todoItem.title}</td>
							<td>${todoItem.content}</td>
						</c:forEach>
					</table>
				</c:if>

				<c:if test="${page=='add'}">
					<h1 class="text-center">Add todo</h1>
					<form:form action="/todoApp/saveTodo" method="post" modelAttribute="todo">
						<div class="form-group">
							<form:input path="title" cssClass="form-control" placeholder="Enter Todo Title"/>
						</div>
							 <div class="form-group">
								 <form:textarea path="content" cssClass="form-control" placeholder="Enter Todo Content"/>
							 </div>
							 <div class="container text-center">
								 <button class="btn btn-outline-success">Add Todo</button>
							 </div>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>