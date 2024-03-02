package com.example.hm17;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
       return employeeService.findAll().stream().filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);


    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employeeService.findAll().stream().filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(comparing(Employee::getFullName))
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartmentId));
    }
}
