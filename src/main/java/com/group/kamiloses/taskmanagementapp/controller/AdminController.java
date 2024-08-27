package com.group.kamiloses.taskmanagementapp.controller;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    private final   AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }





    @PostMapping("/account")
    public String createEmployeeAccount(@RequestBody AccountDto accountDto) {
      adminService.createAccount(accountDto);

        return "Account has been created successfully";


    }
    @DeleteMapping("/account")
    public String deleteEmployeeAccount(@RequestParam String username){

        adminService.deleteEmployeeAccount(username);

        return "Account has been deleted successfully";
    }

    @GetMapping("/employees/without-tasks")
    public List<EmployeeDto> findEmployeesWithoutTask(){

        return adminService.findEmployeesWithoutTask();
    }

    @GetMapping("/employee/{username}")
    public EmployeeDto findEmployeeByUsername(@PathVariable String username){
        return adminService.findEmployeeByUsername(username);

    }
    //todo przetestuj dolną metode
    @PostMapping("/employee/task/{username}")
     public String selectTasksToEmployee(@PathVariable String username, List<TaskDto> taskDto){
       adminService.selectTaskToEmployee(username,taskDto);


        return "tasks successfully selected to user"; }


}
