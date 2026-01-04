package com.example.task.controller;


import com.example.task.infrastructure.entity.dto.TaskDTO;
import com.example.task.infrastructure.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;



    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO request, @RequestHeader("Authorization") String token){
            TaskDTO task = service.registerTask(token,request);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);

   }

    @GetMapping("/list")
    public ResponseEntity<List<TaskDTO>> listAllTask(@RequestHeader("Authorization")String token){

        return ResponseEntity.ok(service.listTasks(token));
    }


}
