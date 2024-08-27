package com.group.kamiloses.taskmanagementapp.security;

import com.group.kamiloses.taskmanagementapp.entity.EmployeeEntity;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CustomUserDetails implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public CustomUserDetails(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        EmployeeEntity employee = employeeRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(
                employee.getUsername(),
                employee.getPassword(),
                roleToGrantedAuthority(employee)
        );
    }
    private List<GrantedAuthority> roleToGrantedAuthority(EmployeeEntity employee) {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(employee.getRole().toString()));
        return list;
    }

}
