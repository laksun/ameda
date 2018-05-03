package com.yla.springboot.firstweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yla.springboot.firstweb.model.Todo;
import com.yla.springboot.firstweb.model.User;
import com.yla.springboot.firstweb.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodosController {

	@Autowired
	TodoService service;
	

	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String todos(ModelMap model,  @SessionAttribute("name") String name) {
		//String name = getLoggedinUserName(model,  name);
		model.put("todos", service.retrieveTodos(name));
		return "todos";

	}

	@RequestMapping(value = "/add-todos", method = RequestMethod.GET)
	public String showAddTodos(ModelMap model) {
		String name = getLoggedinUserName(model);
		model.put("todos", service.retrieveTodos(name));
		model.addAttribute("todo", new Todo(0, name, "", new Date(), false));
		return "addtodos";

	}

	private String getLoggedinUserName(ModelMap model) {
		return (String) model.get("name");
	}
	
	

	@RequestMapping(value = "/add-todos", method = RequestMethod.POST)
	public String addTodos(ModelMap model,@Valid  Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addtodos";
		}
		
		String name = getLoggedinUserName(model);
		service.addTodo(name, todo.getDesc(), todo.getTargetDate(), false);

		return "redirect:/todos";

	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodos(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/todos";

	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showupdateTodos(ModelMap model, @RequestParam int id) {
		//service.deleteTodo(id);
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "addtodos";

	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodos(ModelMap model,  @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addtodos";
		}
		String userName = getLoggedinUserName(model);
		todo.setUser(userName);
		//todo.setDesc(todo.getDesc());
		
		service.updateTodo(todo);
		return "redirect:/todos";

	}

}
