package com.group.kamiloses.taskmanagementapp.service;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import com.group.kamiloses.taskmanagementapp.exception.EmployeeNotFoundException;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import com.group.kamiloses.taskmanagementapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;


@Service
public class AdminService {


    private final EmployeeRepository employeeRepository;
    private final MapperService mapper;
    private final TaskRepository taskRepository;

    public AdminService(EmployeeRepository employeeRepository, MapperService mapper, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
        this.taskRepository = taskRepository;
    }



    public void createAccount(AccountDto accountDto) {
        if (employeeRepository.existsByUsername(accountDto.getUsername())) {
            throw new ThisEmployeeAlreadyExistsException("This employee already exists");
        }//todo obsłuż wyjątek
        employeeRepository.save(mapper.accountDtoToEntity(accountDto));


    }

    public void deleteEmployeeAccount(String username) {
        if (!employeeRepository.existsByUsername(username)) {
            throw new EmployeeNotFoundException("This employee was not found in the database");
        }//todo obsłuż wyjątek
        employeeRepository.deleteByUsername(username);
    }


    public List<EmployeeDto> findEmployeesWithoutTask() {

        return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .filter(employee -> taskRepository.findAllByEmployeeId(employee.getId()).isEmpty()).map(employeeEntity ->
                {
                    EmployeeDto employeeDto = new EmployeeDto();
                    employeeDto.setUsername(employeeEntity.getUsername());
                    employeeDto.setUserTasks(mapper.tasksEntityToDto(employeeEntity));
                    return employeeDto;
                }).toList();

    }



    public EmployeeDto findEmployeeByUsername(String username) {
        return employeeRepository.findByUsername(username)
               .map(employee -> new EmployeeDto(employee.getUsername(),mapper.tasksEntityToDto(employee)))
               .orElseThrow(()->new EmployeeNotFoundException("This employee was not found in the database"));

       //todo obsłuż wyjątek
    }

    public void selectTaskToEmployee(String username, List<TaskDto> taskDto){

        EmployeeEntity employee = employeeRepository.findByUsername(username).orElseThrow(()->new EmployeeNotFoundException("This employee does not exists"));
        List<TaskEntity> list = taskDto.stream().map(task -> {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTitle(task.getTitle());
            taskEntity.setDescription(task.getDescription());
            taskEntity.setTaskStatus(task.getTaskStatus());
            taskEntity.setDeadline(task.getDeadline());
            taskEntity.setEmployeeId(employee.getId());
            return taskEntity;
        }).toList();
        taskRepository.saveAll(list);
    }



}
