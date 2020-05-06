package com.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;

import com.model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Evan Lokajaya
 */

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
    @Query(value = "{ 'name' : ?0}")
    List<Employee> findByName(String name);
    
    @Query(value = "{ 'department' : ?0}")
    List<Employee> findByDepartment(String department);
    
    @Query(value = "{ 'position' : ?0}")
    List<Employee> findByPosition(String position);
}
