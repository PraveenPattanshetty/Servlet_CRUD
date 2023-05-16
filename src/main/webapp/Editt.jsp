<%@page import="assign.dto.DTO"%>
<%@page import="assign.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: rgb(249, 214, 249);
	color: blueviolet;
}

h2 {
	text-align: center;
}

.container {
	max-width: 450px;
	margin: 150px auto;
	text-align: center;
	padding: 10px 25px;
	background-color: rgb(250, 202, 250);
	box-shadow: 0px 0px 100px violet;
	border-radius: 16px;
}

.inner-container {
	max-width: fit-content;
	margin: auto;
}

input {
	display: block;
	margin-bottom: 3px;
	padding: 3px 20px;
	border-radius: 6px;
	border: 1px solid violet;
	background-color: rgb(247, 225, 247);
}

input:hover {
	background-color: rgb(255, 205, 255);
}

button {
	margin-bottom: 3px;
	background-color: rgb(250, 211, 206);
	border: 1px solid salmon;
	border-radius: 3px;
}

button:hover {
	background-color: rgb(248, 170, 160);
	cursor: pointer;
}
</style>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		DAO dao = new DAO();
		DTO dto = dao.fetch(id);
	%>
	<div class="container">
		<h2>UPDATE YOUR DETAILS</h2>
		<form action="update1" method="post">
			<div class="inner-container">
				<input type="text" value=<%=dto.getName()%> name="name"> <input
					type="tel" pattern="[0-9]{10}" value=<%=dto.getMobile()%>
					name="mobile"> <input type="text" value=<%=dto.getId()%>
					name="id" readonly="readonly">
				<button>Submit</button>
				<button type="reset">Reset</button>
			</div>
		</form>
	</div>
</body>
</body>
</html>