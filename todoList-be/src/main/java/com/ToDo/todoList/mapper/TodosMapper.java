package com.ToDo.todoList.mapper;

import com.ToDo.todoList.dto.TodosDto;
import com.ToDo.todoList.entity.Todos;

public class TodosMapper {

    public static TodosDto mapToTodosDto(Todos todos, TodosDto todosDto) {
        todosDto.setTodoId(todos.getTodoId());
        todosDto.setTitle(todos.getTitle());
        return todosDto;
    }

    public static Todos mapToTodos(TodosDto todosDto, Todos todos) {
        todos.setTodoId(todosDto.getTodoId());
        todos.setTitle(todosDto.getTitle());
        return todos;
    }

}
