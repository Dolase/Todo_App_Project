package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.TodoDao;
import com.mydata.dao.TodoDaoImpl;
import com.mydata.dao.UserRegisterDao;
import com.mydata.dao.UserRegisterDaoImpl;
import com.mydata.model.Todo;
import com.mydata.model.UserRegister;

/**
 * Servlet implementation class Addtodoservlet
 */
public class Addtodoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addtodoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		//Long id = Long.parseLong(request.getParameter("id"));
		String ti=request.getParameter("title");
		String un=request.getParameter("username");
		String desc=request.getParameter("description");
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        //LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);
//		String date=request.getParameter("targetDate");
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Boolean stat=Boolean.valueOf(request.getParameter("isDone"));
//		Date d=null;
//		try {
//			d=new Date(sdf.parse(date).getTime());
//		} catch (Exception e) {
//			System.out.println(e);  //
//		}
		Todo t=new Todo(ti, un, desc, LocalDate.now(), stat);
		TodoDao tdao=new TodoDaoImpl();
		int res=tdao.savaTodo(t);
		
		if(res>0) {
			
			request.getRequestDispatcher("List.jsp").forward(request, response);
			
		}
		else{
			out.print("try again!!");
			request.getRequestDispatcher("AddTodo.jsp").include(request, response);
			
		}
		
	}

}
