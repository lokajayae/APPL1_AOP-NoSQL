package com.app;


import com.configuration.MongoConfig;
import java.util.List;
import com.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.service.EmployeeService;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tigress
 */
public class App {
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Controller controller = new Controller(employeeService);
        Scanner scan = new Scanner(System.in);
        
        employeeService.deleteAll();
        
        Employee jake = new Employee("Jake", "IT", "Manager");
        employeeService.create(jake);
        
        Employee tim = new Employee("Tim", "Security", "Chief");
        employeeService.create(tim);
        
        Employee charles = new Employee("Charles", "Cleaning Service", "Commander");
        employeeService.create(charles);
        
        while(controller.getStatus()){
            System.out.println("1 : Create Data");
            System.out.println("2 : Delete Data");
            System.out.println("3 : Update Data");
            System.out.println("4 : Search");
            System.out.println("5 : Retrieve All Data");
            System.out.println("6 : Delete All Data");
            System.out.println("0 : Exit\n");
            
            System.out.print("Choice : ");
            int choice = scan.nextInt();
            
            controller.Execute(choice);
        }
        
        context.close();
    }
}
