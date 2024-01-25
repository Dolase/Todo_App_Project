package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.UserRegisterDao;
import com.mydata.dao.UserRegisterDaoImpl;
import com.mydata.model.UserRegister;

/**
 * Servlet implementation class UserRegisterController
 */
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    	response.sendRedirect("register.jsp");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		String un=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		UserRegister ur=new UserRegister(fn, ln, un, pwd);
		UserRegisterDao ud=new UserRegisterDaoImpl();
		int res=ud.saveUser(ur);
		
		if(res==1) {
			
			request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
		}
		
	}

}
