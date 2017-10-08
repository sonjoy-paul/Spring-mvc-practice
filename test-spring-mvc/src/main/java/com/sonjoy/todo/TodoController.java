package com.sonjoy.todo;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.inject.New;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
    TodoService todoService;  //=new UserValidationService(); 
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	
	
	
	@RequestMapping(value = "/list-todos",method=RequestMethod.GET)
	//@ResponseBody
	public String showTodoPage(ModelMap model) {
		
		model.addAttribute("todos",todoService.retrieveTodos("sonjoy"));
		return "list-todos";
		
	}
	
	@RequestMapping(value = "/add-todo",method=RequestMethod.GET)
	//@ResponseBody
	public String showAddTodopage(ModelMap model) {
		
		//model.addAttribute("todos",todoService.retrieveTodos("sonjoy"));
		model.addAttribute("todo", new Todo());
		return "todo";
		
	}
	
	@RequestMapping(value = "/add-todo",method=RequestMethod.POST)
	//@ResponseBody
	public String AddTodopage(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors())
		{
			return "todo";
		}
		todoService.addTodo("sonjoy", todo.getDesc(), todo.getTargetDate(), false);
		model.clear();
		return "redirect:list-todos";
		
	}
	
	@RequestMapping(value = "/delete-todo",method=RequestMethod.GET)
	//@ResponseBody
	public String deleteTodoPage(@RequestParam int id,ModelMap model) {
		todoService.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
		
	}
	
	@RequestMapping(value = "/update-todo",method=RequestMethod.GET)
	//@ResponseBody
	public String UpdateTodoPage(ModelMap model,@RequestParam int id) {
		model.addAttribute("todo", todoService.retrieveTodo(id));
		//model.clear();
		return "todo";
		
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo,
			BindingResult result) {
		if (result.hasErrors())
			return "todo";

		todo.setUser("sonjoy"); //TODO:Remove Hardcoding Later
		todoService.updateTodo(todo);

		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	


}
