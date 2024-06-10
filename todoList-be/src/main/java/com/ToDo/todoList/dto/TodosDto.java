package com.ToDo.todoList.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodosDto {

    private Long todoId;

    @NotEmpty(message = "Title can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the title name should be between 5 and 30")
    private String title;

}
