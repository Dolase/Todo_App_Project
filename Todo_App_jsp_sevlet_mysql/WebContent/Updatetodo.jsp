
<%@page import="com.mydata.model.Todo"%>
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
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
   
   <% 
  Long i=Long.parseLong(request.getParameter("id"));
   TodoDao td=new TodoDaoImpl();
   Todo t=td.ViewTodoById(i);
   %> 
    <form action="Updatetodoservlet" method="post">
    <input type="hidden" name="id" value="<%=t.getId() %>" />
    <fieldset class="form-group">
     <label>Todo Title</label> <input type="text"
      class="form-control"
      name="title" value="<%=t.getTitle() %>" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Todo Decription</label> <input type="text"
      class="form-control"
      name="description" value="<%=t.getDescription() %>" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Todo Status</label> <select class="form-control"
      name="isDone" value="<%=t.getStatus() %>" >
      <option value="false">In Progress</option>
      <option value="true">Complete</option>
     </select>
    </fieldset>

    <fieldset class="form-group">
     <label>Todo Target Date</label> <input type="date"
       class="form-control"
      name="targetDate" value="<%=t.getTargetDate() %>"  required="required">
    </fieldset>

    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>