package com.group.kamiloses.taskmanagementapp.controller;

import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import com.group.kamiloses.taskmanagementapp.repository.TaskRepository;
import com.group.kamiloses.taskmanagementapp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class EmployeeController {

     private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public List<TaskDto> findAllTasks() {
        return employeeService.findAllTasks();
    }
//todo zaimplementuj że jak status -finished to wtedy rabbit to przechowuje i po tygodniu usuwa


//    @PatchMapping("employee/task/{id}")
//    public String modifyTaskStatus(@PathVariable Long id) {
//    return employeeService.modifyTaskStatus(id);
//
//    }
//

}
