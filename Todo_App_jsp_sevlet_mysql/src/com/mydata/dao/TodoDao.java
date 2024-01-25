package com.mydata.dao;

import java.time.LocalDate;
import java.util.List;

import com.mydata.model.Todo;

public interface TodoDao {

	public List<Todo> viewListOfTodos();
	public int savaTodo(Todo t);
	public int deleteTodoById(int id);
	public Todo ViewTodoById(Long id);
	public int updateTodo(Long id, String title, String username, String description, LocalDate targetDate, boolean isDone);

}
