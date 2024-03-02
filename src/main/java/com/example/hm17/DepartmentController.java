package com.example.hm17;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam int deparmentId) {
        return departmentService.findEmployeeWithMaxSalary(deparmentId);
    }

    @GetMapping("min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam int deparmentId) {
        return departmentService.findEmployeeWithMinSalary(deparmentId);
    }
@GetMapping(value = "all",  params = {"departmentId"})
    public Collection<Employee> findEmployeeByDepartment(@RequestParam int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }
@GetMapping("all")
    public Map<Integer, List<Employee>> findEmployeeByDepartment() {
        return departmentService.findEmployeesByDepartment();
    }

}
