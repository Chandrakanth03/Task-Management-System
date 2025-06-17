package com.chandrakanth.todos.service;

import com.chandrakanth.todos.Model.Todos;
import com.chandrakanth.todos.repo.TodoREpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoREpo todoREpo;

    @Autowired
    public TodoService(TodoREpo todoREpo) {
        this.todoREpo = todoREpo;
    }

    public Todos addTodos(Todos todos) {
        return todoREpo.save(todos);
    }

    public List<Todos> getAllTodos() {
        return todoREpo.findAll();
    }

    public boolean updateTodos(Long id, Todos updateTodos) {
        Todos todos1 = todoREpo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todos1.setTask(updateTodos.getTask());
        todos1.setComplete(updateTodos.isComplete());
        todoREpo.save(todos1);
        return true;
    }

    public void deleteTodo(Long id) {
        todoREpo.deleteById(id);
    }
}
