package com.mydata.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreateConnection {

	private static String dname="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/todo_managment";
	private static String username="root";
	private static String password="root";
	public static Connection initConnection()
	{
		Connection con=null;
	  try {
		Class.forName(dname);
		 con=(Connection) DriverManager.getConnection(url, username, password);
		 //System.out.println("connection done");
	  }
	  catch(Exception e)
	  {
		System.out.println(e);
	  }
	return con;
	
	}
	
	public static Date getSQLDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}

	public static LocalDate getUtilDate(Date sqlDate) {
		return sqlDate.toLocalDate();
	}
}
