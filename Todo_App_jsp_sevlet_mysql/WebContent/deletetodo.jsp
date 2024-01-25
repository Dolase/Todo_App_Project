<%@page import="com.mydata.dao.TodoDaoImpl"%>
<%@page import="com.mydata.dao.TodoDao"%>
<%@page import="com.mydata.model.Todo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int i=Integer.parseInt(request.getParameter("id"));
TodoDao td=new TodoDaoImpl();
int res=td.deleteTodoById(i);
if(res>0)
{

	%>
	<jsp:forward page="List.jsp"></jsp:forward>
	<% 
}
else{
%>
<h2>Try again</h2>
<jsp:include page="List.jsp"></jsp:include>
<% 
}
%>
</body>
</html>