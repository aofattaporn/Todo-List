package com.ToDo.todoList.controller;


import com.ToDo.todoList.dto.ResponseDto;
import com.ToDo.todoList.dto.TodosDto;
import com.ToDo.todoList.service.impl.TodosServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.ToDo.todoList.constains.TodoConstatns.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TodoController {

    private TodosServiceImpl todosService;

    public TodoController(TodosServiceImpl todosService) {
        this.todosService = todosService;
    }

    @GetMapping(path = "v1/todos")
    public HttpEntity<ArrayList<TodosDto>> getTodos() {
        ArrayList<TodosDto> todosDtos = todosService.fetchTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todosDtos);
    }

    @GetMapping(path = "v1/todos/{id}")
    public HttpEntity<TodosDto> getTodoById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(new TodosDto());
    }

    @PostMapping(path = "v1/todos")
    public HttpEntity<ResponseDto> createTodo(@Valid @RequestBody TodosDto todosDto) {
        todosService.createTodo(todosDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(STATUS_201, SAVINGS));
    }

    @PutMapping(path = "v1/todos/{id}")
    public ResponseEntity<ResponseDto> updateTodoById(
            @Valid @RequestBody TodosDto todosDto, @PathVariable("id") Long id) {
        todosService.updateTodo(todosDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(STATUS_200, "Updating Todo Success"));
    }

    @DeleteMapping(path = "v1/todos/{id}")
    public ResponseEntity<ResponseDto>  deleteTodoById(@PathVariable("id") Long id) {
        todosService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(STATUS_200, "Deleting Todo Success"));
    }


}
