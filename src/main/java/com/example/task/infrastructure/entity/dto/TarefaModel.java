package com.example.task.infrastructure.entity.dto;


import com.example.task.infrastructure.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("tasks")
public class TarefaModel {

    @Id
    private String id;
    private String taskname;
    private String description;
    private LocalDateTime date_create;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime evente_date;
    private String email;
    private LocalDateTime edit_date;
    private Status status;

}

