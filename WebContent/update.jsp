<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.bean.User" %>
<%@ page import="model.dao.UserDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		User u = new User();
		UserDAO uDAO = new UserDAO();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		u.setId(Integer.parseInt(id));
		u.setName(name);
		u.setAge(Integer.parseInt(age));
		
		uDAO.update(u);
		
		response.sendRedirect("index.jsp");
		
	%>


</body>
</html>