package com.group.kamiloses.taskmanagementapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.management.relation.Role;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    private Long id;
    private String username;
    private String password;
    private String role;
    private List<TaskEntity> tasks;

}
