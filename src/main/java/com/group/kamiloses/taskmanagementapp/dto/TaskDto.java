package com.group.kamiloses.taskmanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {


    private String title;
    private String description;
    private Date deadline;


}


