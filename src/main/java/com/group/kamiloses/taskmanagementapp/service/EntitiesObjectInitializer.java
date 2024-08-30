//package com.group.kamiloses.taskmanagementapp.service;
//
//import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
//import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
//import com.group.kamiloses.taskmanagementapp.other.Role;
//import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
//import com.group.kamiloses.taskmanagementapp.repository.TaskRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//import static com.group.kamiloses.taskmanagementapp.other.Status.NOT_STARTED;
//
//@Component
//public class EntitiesObjectInitializer {
//
//    private final EmployeeRepository employeeRepository;
//    private final TaskRepository taskRepository;
//
//    public EntitiesObjectInitializer(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
//        this.employeeRepository = employeeRepository;
//        this.taskRepository = taskRepository;
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void addObjects() {
//        EmployeeEntity employee1 = new EmployeeEntity(null, "kamil", "kamil", Role.ROLE_USER, null);
//        EmployeeEntity employee2 = new EmployeeEntity(null, "adam", "adam", Role.ROLE_USER, null);
//        employeeRepository.saveAll(List.of(employee1, employee2));
//        TaskEntity task1 = new TaskEntity(null, "Task 1", "Description for task 1", NOT_STARTED, null, 1L);
//        TaskEntity task2 = new TaskEntity(null, "Task 2", "Description for task 2", NOT_STARTED, null, 1L);
//        TaskEntity task3 = new TaskEntity(null, "Task 3", "Description for task 3", NOT_STARTED, null, 1L);
//        TaskEntity task4 = new TaskEntity(null, "Task 4", "Description for task 4", NOT_STARTED, null, 1L);
//        TaskEntity task5 = new TaskEntity(null, "Task 5", "Description for task 5", NOT_STARTED, null, 1L);
//        TaskEntity task6 = new TaskEntity(null, "Task 6", "Description for task 6", NOT_STARTED, null, 2L);
//        TaskEntity task7 = new TaskEntity(null, "Task 7", "Description for task 7", NOT_STARTED, null, 2L);
//        TaskEntity task8 = new TaskEntity(null, "Task 8", "Description for task 8", NOT_STARTED, null, 2L);
//        TaskEntity task9 = new TaskEntity(null, "Task 9", "Description for task 9", NOT_STARTED, null, 2L);
//        TaskEntity task10 = new TaskEntity(null, "Task 10", "Description for task 10", NOT_STARTED, null, 2L);
//        taskRepository.saveAll(List.of(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10));
//    }
//
//}
