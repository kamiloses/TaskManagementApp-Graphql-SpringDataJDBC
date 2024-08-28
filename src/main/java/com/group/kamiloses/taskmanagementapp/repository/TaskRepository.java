package com.group.kamiloses.taskmanagementapp.repository;

import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TaskRepository extends CrudRepository<TaskEntity,Long> {


    List<TaskEntity> findAllByEmployeeId(Long id);
    Optional<TaskEntity> findAllByIdAndEmployeeId(Long taskId, Long employeeId);
}
