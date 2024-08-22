package com.group.kamiloses.taskmanagementapp.entity;


import com.group.kamiloses.taskmanagementapp.other.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("task")
public class TaskEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    @Column("task_status")
    private Status taskStatus;
    private Date deadline;
    //ManyToOne
    @Column("employee_id")
    private Long employeeId;

}
