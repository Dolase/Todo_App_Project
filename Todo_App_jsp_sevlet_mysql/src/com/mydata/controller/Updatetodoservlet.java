package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.TodoDao;
import com.mydata.dao.TodoDaoImpl;
import com.mydata.model.Todo;

/**
 * Servlet implementation class Updatetodoservlet
 */
public class Updatetodoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatetodoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String description = request.getParameter("description");
        LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
       
		//Todo t=new Todo(id, title, username, description, targetDate, isDone);
		TodoDao tdao=new TodoDaoImpl();
		int res=tdao.updateTodo(id, title, username, description, targetDate, isDone);
		if(res>0){
			request.getRequestDispatcher("List.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("Updatetodo.jsp").include(request, response);
		}
	}

}
