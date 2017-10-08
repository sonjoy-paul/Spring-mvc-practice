package com.sonjoy.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount=3;
	static {
		todos.add(new Todo(1,"sonjoy","Learn Web Application Development",new Date(),false));
		todos.add(new Todo(2,"sonjoy","Learn Spring MVC",new Date(),false));
		todos.add(new Todo(3,"sonjoy","Learn Spring Rest Services", new Date(),false));
	}

	public List<Todo> retrieveTodos() {
		return todos;
	}
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos=new ArrayList<Todo>();
		for(Todo todo:todos)
		{
			if(todo.getUser().equals(user))
			{
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	public void addTodo(String user, String desc, Date targetDate, boolean isDone)
	{
		todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));
	}

	public void deleteTodo(Todo todo) {
		todos.remove(todo);
	}
	public void deleteTodo(int id)
	{
		Iterator<Todo> iterator=todos.iterator();
		while(iterator.hasNext())
		{
			Todo todo=iterator.next();
			if(todo.getId()==id)
			{
				iterator.remove();
			}
		}
	}
	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}

}
