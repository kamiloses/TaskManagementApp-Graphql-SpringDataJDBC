package com.group.kamiloses.taskmanagementapp.repository;

import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity,Long> {

}
