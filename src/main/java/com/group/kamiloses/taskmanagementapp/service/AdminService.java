package com.group.kamiloses.taskmanagementapp.service;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.exception.EmployeeNotFoundException;
import com.group.kamiloses.taskmanagementapp.other.Role;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import static com.group.kamiloses.taskmanagementapp.other.Role.ROLE_ADMIN;

@Service
public class AdminService {


    private final EmployeeRepository employeeRepository;
    private final MapperService mapper;

    public AdminService(EmployeeRepository employeeRepository, MapperService mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }



    public void createAccount(AccountDto accountDto) {
        if (employeeRepository.findByUsername(accountDto.getUsername()).isEmpty()) {
            throw new ThisEmployeeAlreadyExistsException("This employee already exists");
        }//todo obsłuż wyjątek
        employeeRepository.save(mapper.accountDtoToEntity(accountDto));


    }

    public void deleteEmployeeAccount(Long id) {
        if (employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("This employee was not found in the database");
        }//todo obsłuż wyjątek
        employeeRepository.deleteById(id);
    }


    public List<EmployeeDto> findEmployeesWithoutTask() {

        return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .filter(employee -> employee.getTasks() == null).map(employeeEntity ->
                {
                    EmployeeDto employeeDto = new EmployeeDto();
                    employeeDto.setUsername(employeeEntity.getUsername());
                    employeeDto.setUserTasks(mapper.tasksEntityToDto(employeeEntity.getTasks()));
                    return employeeDto;
                }).toList();

    }

    public List<EmployeeDto> findEmployeesSortedByNearestDeadline() {

        return employeeRepository.findEmployeesSortedByNearestDeadline()
                .stream().map(employeeEntity ->
                {
                    EmployeeDto employeeDto = new EmployeeDto();
                    employeeDto.setUsername(employeeEntity.getUsername());
                    employeeDto.setUserTasks(mapper.tasksEntityToDto(employeeEntity.getTasks()));
                    return employeeDto;
                }).toList();
    }


    public EmployeeDto findEmployeeByUsername(String username) {

       return employeeRepository.findByUsername(username)
               .map(employee -> new EmployeeDto(employee.getUsername(),employee.getUsername(),mapper.tasksEntityToDto(employee.getTasks())))
               .orElseThrow(()->new EmployeeNotFoundException("This employee was not found in the database"));
//todo obsłuż wyjątek
    }




}
