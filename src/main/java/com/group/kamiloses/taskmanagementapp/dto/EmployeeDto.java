package com.group.kamiloses.taskmanagementapp.dto;

import com.group.kamiloses.taskmanagementapp.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @IsUnique
    private String username;
    private String password;
    private List<TaskDto> userTasks;


}
