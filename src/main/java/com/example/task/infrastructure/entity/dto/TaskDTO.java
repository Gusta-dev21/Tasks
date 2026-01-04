package com.example.task.infrastructure.entity.dto;

import com.example.task.infrastructure.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data

public class TaskDTO {


    private String taskname;
    private String description;
    private LocalDateTime date_create;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime evente_date;
    private String email;
    private LocalDateTime edit_date;
    private Status status;
}
