<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Hello login page</h1>
		<h1>Hello ${firstname } ${lastname }</h1>
		<form action="" class="form-control" method="post" >
			FirstName:<input type="text" name="firstname" id="firstname"
				required="required" /> 
			LastName:<input type="text" name="lastname"
				id="lastname" required="required" /> 
			<input type="submit"
				value="Save" class="btn btn-primary" />
		</form>
		<p>${message }</p>
	</div>
</body>
</html>