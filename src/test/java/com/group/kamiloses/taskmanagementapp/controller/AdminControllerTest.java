package com.group.kamiloses.taskmanagementapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.group.kamiloses.taskmanagementapp.dto.AccountDto;
import com.group.kamiloses.taskmanagementapp.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AdminControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    @MockBean
    private AdminService adminService;
    @Mock
    AdminController adminController;


    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }
    @Test
    void testCreateEmployeeAccount() throws Exception {
        AccountDto accountDto = new AccountDto("admin","admin123");
        String body = objectWriter.writeValueAsString(accountDto);
        mockMvc.perform(post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

//    @Test
//    void testDeleteEmployeeAccount() throws Exception {
//        String username="adam";
//
//        mockMvc.perform(delete("/account/{username}", username))
//                .andExpect(status().isOk());
//    }



//
//    @Test
//    void testFindEmployeesByDeadline() throws Exception {
//        EmployeeDto employeeDto = new EmployeeDto(); // Populate with test data if needed
//        List<EmployeeDto> employees = Collections.singletonList(employeeDto);
//
//        when(adminService.findEmployeesSortedByNearestDeadline()).thenReturn(employees);
//
//        mockMvc.perform(get("/employee/by-deadline"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].someField").value("someValue")); // Adjust based on your EmployeeDto
//    }
//
//    @Test
//    void testFindEmployeeByUsername() throws Exception {
//        String username = "testuser";
//        EmployeeDto employeeDto = new EmployeeDto(); // Populate with test data if needed
//
//        when(adminService.findEmployeeByUsername(username)).thenReturn(employeeDto);
//
//        mockMvc.perform(get("/employee/{username}", username))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.someField").value("someValue")); // Adjust based on your EmployeeDto
//    }
//

}