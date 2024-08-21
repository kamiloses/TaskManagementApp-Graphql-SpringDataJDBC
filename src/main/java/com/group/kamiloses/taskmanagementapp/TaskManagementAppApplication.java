package com.group.kamiloses.taskmanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.group.kamiloses.taskmanagementapp.repository")
public class TaskManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementAppApplication.class, args);
    }

}
