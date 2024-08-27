package com.group.kamiloses.taskmanagementapp.controller;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.service.AdminService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    private final   AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }





    @PostMapping("/account")
    public String createEmployeeAccount(@RequestBody AccountDto accountDto) {
      adminService.createAccount(accountDto); //todo obsłuż

        return "Account has been created successfully";


    }
    @DeleteMapping("/account")
    public String deleteEmployeeAccount(@RequestParam String username){

        adminService.deleteEmployeeAccount(username);//todo obsłuż

        return "Account has been deleted successfully";
    }

    @GetMapping("/employees/without-tasks")
    public List<EmployeeDto> findEmployeesWithoutTask(){//todo obsłuż

        return adminService.findEmployeesWithoutTask();
    }

    @QueryMapping("getEmployeeByUsername")
    public EmployeeDto findEmployeeByUsername(@Argument String username){
        return adminService.findEmployeeByUsername(username);//todo obsłuż

    }
    //todo przetestuj dolną metode
    @PostMapping("/employee/task/{username}")
     public String selectTasksToEmployee(@PathVariable String username, List<TaskDto> taskDto){
       adminService.selectTaskToEmployee(username,taskDto);//todo obsłuż


        return "tasks successfully selected to user"; }


}
