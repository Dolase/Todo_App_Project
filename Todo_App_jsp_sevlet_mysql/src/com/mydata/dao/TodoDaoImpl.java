package com.mydata.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mydata.model.Todo;
import com.mydata.util.CreateConnection;

public class TodoDaoImpl implements TodoDao {

	Connection con=CreateConnection.initConnection();
	@Override
	public List<Todo> viewListOfTodos() {
		//System.out.println("viewListOfTodos");
		List<Todo> ltodo=new ArrayList<>();
		try {
			//System.out.println("before prepared statment");
			PreparedStatement ps=con.prepareStatement("select * from todos");
			ResultSet rs=ps.executeQuery();
			//System.out.println("after prepared statment");
			//System.out.println("before prepared while");
			while(rs.next())
			{
				//System.out.println("in while..");
				
				long id = rs.getLong("id");
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                boolean isDone = rs.getBoolean("is_done");
                ltodo.add(new Todo(id, title, username, description, targetDate, isDone));
           
				
			/*	
			Todo t=new Todo(rs.getLong("id"), rs.getString("title"),rs.getString("username"), rs.getString("description"),rs.getDate("targetDate").toLocalDate(), rs.getBoolean("is_done"));	

			System.out.println("id"+rs.getLong(1));
			System.out.println("title"+rs.getString(2));
			System.out.println("username"+rs.getString(3));
			System.out.println("desc"+rs.getString(4));
			System.out.println("tarDate"+rs.getDate(5).toLocalDate());
			System.out.println("status"+rs.getBoolean(6));
*/
			
//				Todo t=new Todo();
//				t.setId(rs.getLong(1));
//				t.setTitle(rs.getString(2));
//				t.setUsername(rs.getString(3));
//				t.setDescription(rs.getString(4));
//				t.setTargetDate(rs.getDate(5).toLocalDate());
//				t.setStatus(rs.getBoolean(6));
				//ltodo.add(t);
				//System.out.println(t);
			}
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return ltodo;
		
		
	}
	@Override
	public int savaTodo(Todo t) {
		int x=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into todos(title, username, description, target_date,  is_done)values(?,?,?,?,?)");
			ps.setString(1, t.getTitle());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getDescription());
			ps.setDate(4, CreateConnection.getSQLDate(t.getTargetDate()));
			ps.setBoolean(5, t.getStatus());
			x=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	@Override
	public int deleteTodoById(int id) {
		int x=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from todos where id=?");
			ps.setInt(1, id);
			x=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	@Override
	public Todo ViewTodoById(Long id) {
		Todo c=new Todo();
		try {
			PreparedStatement ps=con.prepareStatement("select * from todos where id=?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				c.setId(rs.getLong(1));
				c.setTitle(rs.getString(2));
				c.setUsername(rs.getString(3));
				c.setDescription(rs.getString(4));
				c.setTargetDate(rs.getDate(5).toLocalDate());
				c.setStatus(rs.getBoolean(6));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return c;
	}
	@Override
	public int updateTodo(Long id, String title, String username, String description, LocalDate targetDate, boolean isDone) {
		int x=0;
		try {
			 PreparedStatement ps=con.prepareStatement("update todos set title = ?, username= ?, description =?, target_date =?, is_done = ? where id =?");
			    ps.setString(1, title);
	            ps.setString(2, username);
	            ps.setString(3, description);
	            ps.setDate(4, CreateConnection.getSQLDate(targetDate));
	            ps.setBoolean(5, isDone);
	            ps.setLong(6,id);
			
		} catch (Exception e) {
			System.out.println(e);
		}
			return x;
	}

	
}
