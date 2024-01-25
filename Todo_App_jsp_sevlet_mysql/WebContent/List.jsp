<%@page import="com.mydata.model.Todo"%>
<%@page import="java.util.List"%>
<%@page import="com.mydata.dao.TodoDaoImpl"%>
<%@page import="com.mydata.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div class="navbar-brand"> Todo App
   </div>

   <ul class="navbar-nav">
    <li><a href="List.jsp"
     class="nav-link">Todos</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="logout.jsp"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>

 <div class="row">
 
  <div class="container">
   <h3 class="text-center">List of Todos</h3>
   <hr>
   <div class="container text-left">

    <a href="AddTodo.jsp"
     class="btn btn-success">Add Todo</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Title</th>
      <th>Target Date</th>
      <th>Todo Status</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
    <% 
    TodoDao td=new TodoDaoImpl();
    List<Todo> list=td.viewListOfTodos();
    for(Todo t:list)
    {
    %>
      <tr>
       <td><%= t.getTitle()%></td>
       <td><%=t.getTargetDate()%></td>
       <td><%=t.getStatus()%></td>

       <td><a href="Updatetodo.jsp?id=<%=t.getId()%>">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="deletetodo.jsp?id=<%=t.getId()%>">Delete</a></td>
      </tr>
      
      <%} %>
     
     
    </tbody>

   </table>
  </div>
 </div>

 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>