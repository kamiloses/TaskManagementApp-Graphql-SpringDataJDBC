package com.group.kamiloses.taskmanagementapp.controller;

import com.group.kamiloses.taskmanagementapp.dto.EmployeeDto;
import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.other.Role;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.GraphQlResponse;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.ActiveProfiles;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureGraphQlTester
@SpringBootTest
@ActiveProfiles("test")
class AdminControllerTest {

    @Autowired
    GraphQlTester graphQlTester;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository.deleteAll();
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setUsername("Adam");
        employeeEntity.setPassword("Adam");
        employeeEntity.setRole(Role.ROLE_USER);
        employeeRepository.save(employeeEntity);
    }

    @Test
    void testFindEmployeeByUsername() {
        String document = """
                query {
                    getEmployeeByUsername(username: "Adam") {
                        username
                        userTasks {
                            title
                            description
                            taskStatus
                            deadline
                        }
                    }
                }
                """;
        graphQlTester.document(document).execute().path("getEmployeeByUsername").entity(EmployeeDto.class)
                .satisfies(employee -> {
                    assertEquals("Adam", employee.getUsername());

                });

    }

    @Test
    void testFindEmployeeByUsernameNotFound() {
        String document = """
                query {
                    getEmployeeByUsername(username: "123") {
                        username
                        userTasks {
                            title
                            description
                            taskStatus
                            deadline
                        }
                    }
                }
                """;


        graphQlTester.document(document).execute().errors().expect(
                exception -> {
                    assertEquals("This employee was not found in the database", exception.getMessage());
                    return true;
                });


    }


    @Test
    void testFindEmployeeWithoutTask() {
        String document = """
                query{
                findEmployeesWithoutTask{
                username
                userTasks{
                title
                }
                                
                }
                                
                }
                """;

        graphQlTester.document(document)
                .execute()
                .path("findEmployeesWithoutTask[*].userTasks[*].title")
                .entityList(String.class)
                .hasSize(0);
    }


    @Test
    void testCreateEmployeeAccount() {
        String document = """
                mutation CreateEmployeeAccount($accountDto: AccountDto!) {
                  createEmployeeAccount(accountDto: $accountDto)
                }
                """;

        Map<String, Object> variables = Map.of(
                "accountDto", Map.of(
                        "username", "Jan",
                        "password", "Kowalski"));


          graphQlTester.document(document).variables(variables).execute().path("createEmployeeAccount")
                  .entity(String.class).isEqualTo("Account has been created successfully")
                ;

    }
    @Test
    void testDeleteEmployeeAccount(){
        String document= """
                mutation deleteAccount($username: String){
                  deleteEmployeeAccount(username:$username)
                }
                """;
        Map<String, Object> variables = Map.of(
                "username", "Adam");

        graphQlTester.document(document).variables(variables).execute().path("deleteEmployeeAccount")
                .entity(String.class).isEqualTo("Account has been deleted successfully");
    }





}
