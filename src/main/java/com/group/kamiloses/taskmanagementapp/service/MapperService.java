package com.group.kamiloses.taskmanagementapp.service;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import com.group.kamiloses.taskmanagementapp.other.Role;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.group.kamiloses.taskmanagementapp.other.Role.ROLE_USER;

@Service
 public class MapperService {


    protected EmployeeEntity accountDtoToEntity(AccountDto accountDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setRole(ROLE_USER);//todo upewnij sie o role
        employeeEntity.setUsername(accountDto.getUsername());
        employeeEntity.setPassword(accountDto.getPassword());

        return employeeEntity;
    }

    protected List<TaskDto> tasksEntityToDto(List<TaskEntity> taskEntity) {
        return taskEntity.stream().map(task -> new TaskDto(task.getTitle(), task.getDescription(),task.getTaskStatus(), task.getDeadline())).toList();
    }

}
