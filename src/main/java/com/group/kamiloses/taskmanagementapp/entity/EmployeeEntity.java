package com.group.kamiloses.taskmanagementapp.entity;

import com.group.kamiloses.taskmanagementapp.other.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("employee")
public class EmployeeEntity {
    @Id
    private Long id;
    private String username;
    private String password;
    private Role role;
    //OneToMany(mapped by)
    private transient List<TaskEntity> tasks;

}
