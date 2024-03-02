package com.example.hm17;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;



public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int departmentId);
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Collection<Employee> findAll();


}
