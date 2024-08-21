package com.group.kamiloses.taskmanagementapp.repository;

import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {

    EmployeeEntity findByUsername(String username);

}
