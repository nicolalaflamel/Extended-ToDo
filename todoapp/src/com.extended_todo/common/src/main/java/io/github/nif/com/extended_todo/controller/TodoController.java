package com.example.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") Long id) {
    	Todo todo;
    	if (id != null) {
    		todo = todoService.getTodoById(id).orElse(new Todo());
    	} else {
    		todo = new Todo();
    	}
    	model.addAttribute("todos", todoService.getAllTodos());
    	model.addAttribute("todo", todo);
    	return "index";
    }
    
    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
    	todoService.addTodo(todo);
    	return "redirect:/";
    }
    
    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute Todo todo) {
    	todoService.updateTodo(id, todo);
        return "redirect:/";
    }
    
    @PostMapping("/complete/{id}")
    public String completeTodo(@PathVariable Long id) {
    	todoService.completeTodo(id);
    	return "redirect:/";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }
}

