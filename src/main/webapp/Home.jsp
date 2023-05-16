<%@page import="assign.dto.DTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 25px;
	background-color: #f5d7d7;
}

.container {
	max-width: fit-content;
	margin: 150px auto;
	background-color: rgb(252, 217, 217);
	box-shadow: 0px 0px 100px rgb(255, 119, 119);
}

td, th {
	padding: 12px 30px;
	border-radius: 10px;
	text-align: center;
}

button {
	padding: 10px 25px;
	font-size: 20px;
	background-color: rgb(214, 83, 60);
	color: rgb(83, 2, 21);
	border-radius: 15px;
}

button:hover {
	padding: 12px 30px;
	background-color: rgb(222, 61, 33);
	cursor: pointer;
}
</style>
</head>
<body>

	<%
		DTO dto = (DTO) request.getAttribute("dto");
	%>
	<div class="container">

		<table border="1">
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getMobile()%></td>
				<td><a href="Editt.jsp?id=<%=dto.getId()%>"><button>EDIT</button></a></td>
				<td><a href="delete?id=<%=dto.getId()%>"><button>DELETE</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>