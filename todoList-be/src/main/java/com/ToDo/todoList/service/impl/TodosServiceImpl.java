package com.ToDo.todoList.service.impl;

import com.ToDo.todoList.dto.TodosDto;
import com.ToDo.todoList.entity.Todos;
import com.ToDo.todoList.exeption.ResourceNotFoundException;
import com.ToDo.todoList.mapper.TodosMapper;
import com.ToDo.todoList.repository.TodosRepository;
import com.ToDo.todoList.service.ITodosService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodosServiceImpl implements ITodosService {

    private TodosRepository todosRepository;

    public TodosServiceImpl(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @Override
    public ArrayList<TodosDto> fetchTodos() {
        List<Todos> todos = todosRepository.findAll();
        ArrayList<TodosDto> todosDto = new ArrayList<>();

        todos.forEach((item) -> todosDto.add(TodosMapper.mapToTodosDto(item, new TodosDto())));
        return todosDto;
    }

    @Override
    public void createTodo(TodosDto todosDto) {
        Todos todos = TodosMapper.mapToTodos(todosDto, new Todos());
        todosRepository.save(todos);
    }

    @Override
    public boolean updateTodo(TodosDto todosDto, Long todoId) {
        boolean isUpdated = false;
        if (todosDto != null) {
            Todos todos = todosRepository.findById(todoId).orElseThrow(
                    () -> new ResourceNotFoundException("Todos", "Todo Id", todoId.toString())
            );

            todos.setTitle(todosDto.getTitle());
            todosRepository.save(todos);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteTodo(Long id) {
        todosRepository.deleteById(id);
        return true;
    }

}
