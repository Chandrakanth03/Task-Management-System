package com.chandrakanth.todos.controller;

import com.chandrakanth.todos.Model.Todos;
import com.chandrakanth.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todos> findAll() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todos createTodos(@RequestBody Todos todos) {
        return todoService.addTodos(todos);
    }

    @PutMapping("/{id}")
    public boolean updateTodos(@PathVariable Long id, @RequestBody Todos todos) {  // ✅ same fix: @RequestBody
        return todoService.updateTodos(id, todos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
