package com.group.kamiloses.taskmanagementapp.service;

import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import com.group.kamiloses.taskmanagementapp.exception.InvalidIdentifierException;
import com.group.kamiloses.taskmanagementapp.other.Status;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import com.group.kamiloses.taskmanagementapp.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final MapperService mapper;
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    public EmployeeService(MapperService mapper, EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.mapper = mapper;
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    public List<TaskDto> findAllTasks() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        EmployeeEntity employee = employeeRepository.findByUsername(username).get();
        return mapper.tasksEntityToDto(employee);
    }

    public String modifyTaskStatus(Long id) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        EmployeeEntity employee = employeeRepository.findByUsername(username).get();


        TaskEntity taskEntity = taskRepository.findAllByIdAndEmployeeId(id, employee.getId()).get();
        if (taskEntity.getTaskStatus().equals(Status.FINISHED)) {
            throw new InternalException("You cannot modify finished Task");
        }
        if (taskEntity.getTaskStatus().equals(Status.IN_PROGRESS)) {
            taskEntity.setTaskStatus(Status.FINISHED);
        }
        if (taskEntity.getTaskStatus().equals(Status.NOT_STARTED)) {
            taskEntity.setTaskStatus(Status.IN_PROGRESS);
        }
        taskRepository.save(taskEntity);
        return "Status has been modified successfully";
    }



}



