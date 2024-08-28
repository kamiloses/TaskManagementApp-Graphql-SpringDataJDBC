package com.group.kamiloses.taskmanagementapp.service;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import com.group.kamiloses.taskmanagementapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.group.kamiloses.taskmanagementapp.other.Role.ROLE_USER;

@Service
public class MapperService {
    private TaskRepository taskRepository;

    public MapperService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    protected EmployeeEntity accountDtoToEntity(AccountDto accountDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setRole(ROLE_USER);
        employeeEntity.setUsername(accountDto.getUsername());
        employeeEntity.setPassword(accountDto.getPassword());

        return employeeEntity;
    }

    protected List<TaskDto> tasksEntityToDto(EmployeeEntity employee) {
        List<TaskEntity> taskEntity = taskRepository.findAllByEmployeeId(employee.getId());
        if (taskEntity == null) return Collections.emptyList();
        return taskEntity.stream().map(task -> new TaskDto(task.getTitle(), task.getDescription(), task.getTaskStatus(), task.getDeadline(),task.getEmployeeId())).toList();
    }

}
