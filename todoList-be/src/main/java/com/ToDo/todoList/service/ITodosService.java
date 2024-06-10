package com.ToDo.todoList.service;


import com.ToDo.todoList.dto.TodosDto;

import java.util.ArrayList;

public interface ITodosService {

    ArrayList<TodosDto> fetchTodos();

    void createTodo(TodosDto todosDto);

    boolean updateTodo(TodosDto todosDto, Long id);

    boolean deleteTodo(Long id);

}
