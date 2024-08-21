package com.group.kamiloses.taskmanagementapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private Date deadline;

}
