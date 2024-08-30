package com.group.kamiloses.taskmanagementapp.controller;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.service.AdminService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminController {

    private final   AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }





    @MutationMapping("createEmployeeAccount")
    public String createEmployeeAccount(@Argument AccountDto accountDto) {
      adminService.createAccount(accountDto);

        return "Account has been created successfully";


    }
    @MutationMapping("deleteEmployeeAccount")
    public String deleteEmployeeAccount(@Argument String username){

        adminService.deleteEmployeeAccount(username);

        return "Account has been deleted successfully";
    }

    @QueryMapping("findEmployeesWithoutTask")
    public List<EmployeeDto> findEmployeesWithoutTask(){

        return adminService.findEmployeesWithoutTask();
    }

    @QueryMapping("getEmployeeByUsername")
    //@Cacheable(value = "employees",key = "#username")
    public EmployeeDto findEmployeeByUsername(@Argument String username){
        return adminService.findEmployeeByUsername(username);

    }
    @MutationMapping("selectTasksToEmployee")
    //@CachePut(value = "userTasks",key ="#username")
     public String selectTasksToEmployee(@Argument String username,@Argument List<TaskDto> taskDto){
       adminService.selectTaskToEmployee(username,taskDto);


        return "tasks successfully selected to user"; }


}
