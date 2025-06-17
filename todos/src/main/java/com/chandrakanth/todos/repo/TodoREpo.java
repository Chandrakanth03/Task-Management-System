package com.chandrakanth.todos.repo;

import com.chandrakanth.todos.Model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoREpo extends JpaRepository<Todos,Long> {


}
