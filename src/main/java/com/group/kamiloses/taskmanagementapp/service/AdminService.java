package com.group.kamiloses.taskmanagementapp.service;

import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import com.group.kamiloses.taskmanagementapp.exception.EmployeeNotFoundException;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class AdminService {


private final EmployeeRepository employeeRepository;

    public AdminService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createAccount(AccountDto accountDto){
        if (employeeRepository.findByUsername(accountDto.getUsername())==null){
            throw new ThisEmployeeAlreadyExists();
        }
      employeeRepository.save(accountDtoToEntity(accountDto));
//todo zaimplementuj że jeżeli username już insteje w bazie danych to error

}
public void deleteEmployeeAccount(Long id){
    if (!employeeRepository.existsById(id)){
        throw new EmployeeNotFoundException("This user was not found in our database");
    }
        employeeRepository.deleteById(id);
}



public Stream<EmployeeDto> findEmployeesWithoutTask(){

    return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
            .filter(employee->employee.getTasks().isEmpty()).map(employeeEntity ->
                    {
                        EmployeeDto employeeDto = new EmployeeDto();
                        employeeDto.setUsername(employeeEntity.getUsername());
                        employeeDto.setUserTasks(tasksEntityToDto(employeeEntity.getTasks()));
                    return employeeDto;
                    });

}



public EmployeeDto findEmployeeById(Long id){

        employeeRepository.findById(id).orElseThrow(new UserNotFoundException());
}







private EmployeeEntity accountDtoToEntity(AccountDto accountDto){
    EmployeeEntity employeeEntity = new EmployeeEntity();
    employeeEntity.setRole("USER");//todo upewnij sie o role
    employeeEntity.setUsername(accountDto.getUsername());
    employeeEntity.setPassword(accountDto.getPassword());

return employeeEntity;
}

private List<TaskDto>tasksEntityToDto(List<TaskEntity> taskEntity){
   return taskEntity.stream().map(task->new TaskDto(task.getTitle(),task.getDescription(),task.getDeadline())).toList();
}


}
