package com.group.kamiloses.taskmanagementapp.repository;

import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {

    Optional<EmployeeEntity> findByUsername(String username);
    @Query("SELECT * FROM employee ORDER BY deadline ASC")
    List<EmployeeEntity> findEmployeesSortedByNearestDeadline();

}
