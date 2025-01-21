package com.example.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todoRecieved) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(todoRecieved.getTitle());
        todo.setDescription(todoRecieved.getDescription());
        return todoRepository.save(todo);
    }

    public Todo completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(true);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
