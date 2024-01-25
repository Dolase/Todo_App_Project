package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.UserLoginDao;
import com.mydata.dao.UserLoginDaoImpl;
import com.mydata.dao.UserRegisterDao;
import com.mydata.dao.UserRegisterDaoImpl;
import com.mydata.model.UserLogin;
import com.mydata.model.UserRegister;

/**
 * Servlet implementation class UserLoginController
 */
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	response.sendRedirect("Login.jsp");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String un=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		UserLogin ul=new UserLogin(un, pwd);
		UserLoginDao ud=new UserLoginDaoImpl();
		String res =ud.validUser(ul);
		if(res.equalsIgnoreCase("valid"))
		{
			request.getRequestDispatcher("List.jsp").forward(request, response);
		}
		else{
			out.print("Invalid username and password");
			request.getRequestDispatcher("Login.jsp").include(request, response);
			
		}
	}

}
