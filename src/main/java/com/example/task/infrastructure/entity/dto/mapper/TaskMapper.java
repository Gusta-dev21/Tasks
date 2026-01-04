package com.example.task.infrastructure.entity.dto.mapper;


import com.example.task.infrastructure.entity.dto.TarefaModel;
import com.example.task.infrastructure.entity.dto.TaskDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {


    TarefaModel toModel(TaskDTO request);
    TaskDTO toDTO(TarefaModel model);
}
