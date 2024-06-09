package com.ToDo.todoList.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class todosDto {

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="due_date")
    private LocalDate dueDate;


}
