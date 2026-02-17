package com.example.employeecurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.employeecurd.entity.Employee;
import com.example.employeecurd.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();

    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }
    
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        return repository.save(employee);
    }

   
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        repository.deleteById(id);
    }
}
