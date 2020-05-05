/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.List;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.EmployeeRepository;

/**
 *
 * @author Tigress
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findByDepartment(String dept) {
        return employeeRepository.findByDepartment(dept);
    }

    @Override
    public List<Employee> findByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    
    
}
