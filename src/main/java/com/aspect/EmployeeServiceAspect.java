/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Evan Lokajaya
 */

@Aspect
public class EmployeeServiceAspect {
    //Aspect for create data
    @After("execution(* com.service.EmployeeServiceImpl.create(..))")
    public void createDataAdvice(){
        System.out.println("New Data Added...");
    }
    
    //Aspect for update data
    @After("execution(* com.service.EmployeeServiceImpl.update(..))")
    public void updateDataAdvice(){
        System.out.println("Data Updated...");
    }
    
    //Aspect for delete data
    @After("execution(* com.service.EmployeeServiceImpl.delete(..))")
    public void deleteDataAdvice(){
        System.out.println("Data Deleted...");
    }
    
    //Aspect for delete all data
    @After("execution(* com.service.EmployeeServiceImpl.deleteAll(..))")
    public void deleteAllDataAdvice(){
        System.out.println("All Data Deleted...");
    }
    
    //Aspect for find by name
    @Before("execution(* com.service.EmployeeServiceImpl.findByName(..))")
    public void findByNameBeforeAdvice(){
        System.out.println("Perform Searching by Name...");
    }
    
    @After("execution(* com.service.EmployeeServiceImpl.findByName(..))")
    public void findByNameAfterAdvice(){
        System.out.println("Searching by name finished...");
    }
    
    //Aspect for find by department
    @Before("execution(* com.service.EmployeeServiceImpl.findByDepartment(..))")
    public void findByDepartmentBEforeAdvice(){
        System.out.println("Perform Searching by Department...");
    }
    
    @After("execution(* com.service.EmployeeServiceImpl.findByDepartment(..))")
    public void findByDepartmentAdvice(){
        System.out.println("Searching by department finished...");
    }
    
    //Aspect for find by position
    @Before("execution(* com.service.EmployeeServiceImpl.findByPosition(..))")
    public void findByPositionBeforeAdvice(){
        System.out.println("Perform Searching by Position...");
    }
    
    @After("execution(* com.service.EmployeeServiceImpl.findByPosition(..))")
    public void findByPositionAfterAdvice(){
        System.out.println("Searching by position finished...");
    }
}
