package com.mydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mydata.model.UserRegister;
import com.mydata.util.CreateConnection;

public class UserRegisterDaoImpl implements UserRegisterDao{

	Connection con=CreateConnection.initConnection();
	
	@Override
	public int saveUser(UserRegister u) {
		int x=0;
		try {
			
	PreparedStatement ps=con.prepareStatement("insert into user value(?,?,?,?)");
	ps.setString(1, u.getFirstName());
	ps.setString(2, u.getLastName());
	ps.setString(3, u.getUsername());
	ps.setString(4, u.getPassword());
	
	x=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return x;
		
	}

}
