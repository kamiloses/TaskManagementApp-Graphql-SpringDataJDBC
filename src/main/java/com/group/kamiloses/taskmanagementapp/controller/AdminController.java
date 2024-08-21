package com.group.kamiloses.taskmanagementapp.controller;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.exception.EmployeeNotFoundException;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import com.group.kamiloses.taskmanagementapp.service.AdminService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private AdminService adminService;
    private EmployeeRepository employeeRepository;
    public String createEmployeeAccount(AccountDto accountDto) {
      adminService.createAccount(accountDto);

        return "Account has been created successfully";


    }
    public String deleteEmployeeAccount(Long id){
        adminService.deleteEmployeeAccount(id);

        return "Account has been deleted successfully";
    }

    public List<EmployeeDto> findEmployeesWithoutTask(){
     adminService.findEmployeesWithoutTask();
    }

    public List<EmployeeDto> findEmployeesByDeadline(){


    }
     public String selectTasksToEmployee(){


     }


}
