package com.example.task.infrastructure.repository;

import com.example.task.infrastructure.entity.dto.TarefaModel;
import com.example.task.infrastructure.entity.dto.TaskDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends MongoRepository<TarefaModel,String> {


    List<TarefaModel> findTasksByEmail(String email);
}
