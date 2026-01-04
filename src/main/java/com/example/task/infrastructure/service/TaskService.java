package com.example.task.infrastructure.service;


import com.example.task.infrastructure.entity.dto.TarefaModel;
import com.example.task.infrastructure.entity.dto.TaskDTO;
import com.example.task.infrastructure.entity.dto.mapper.TaskMapper;
import com.example.task.infrastructure.enums.Status;
import com.example.task.infrastructure.repository.TaskRepository;
import com.example.task.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {


    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final JwtUtil jwtUtil;

    public TaskDTO registerTask(String token,TaskDTO request){
            String email = jwtUtil.extractUsername(token.substring(7));


            request.setDate_create(LocalDateTime.now());
            request.setStatus(Status.PENDENTE);
            request.setEmail(email);
            TarefaModel task = taskMapper.toModel(request);
            TarefaModel newTask = taskRepository.save(task);

            return taskMapper.toDTO(newTask);

    }


    public List<TaskDTO> listTasks(String token){
            String email = jwtUtil.extractUsername(token.substring(7));

            List<TarefaModel> listTask = taskRepository.findTasksByEmail(email);
            return listTask.stream().map(taskMapper::toDTO).toList();
    }

}
