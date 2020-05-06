/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.List;
import com.model.Employee;

/**
 *
 * @author Evan Lokajaya
 */
public interface EmployeeService {
    public void create(Employee employee);
    
    public void update(Employee employee);
    
    public void delete(Employee employee);
    
    public void deleteAll();
    
    public List<Employee> findByName(String name);
    
    public List<Employee> findByDepartment(String dept);
    
    public List<Employee> findByPosition(String position);
    
    public List<Employee> findAll();
}
