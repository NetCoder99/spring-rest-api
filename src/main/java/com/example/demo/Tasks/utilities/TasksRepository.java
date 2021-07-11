package com.example.demo.Tasks.utilities;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Tasks.models.TaskDefinition;

public interface TasksRepository  extends CrudRepository<TaskDefinition, Integer>{

}
