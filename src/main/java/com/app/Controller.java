/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.model.Employee;
import com.service.EmployeeService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tigress
 */
public class Controller {
    EmployeeService employeeService;
    boolean status;
    Scanner scan;
    
    public Controller(EmployeeService employeeService){
        this.employeeService = employeeService;
        this.status = true;
        scan = new Scanner(System.in);
    }
    
    public void Execute(int input){
        List<Employee> employees, listName, listPosition, listDepartment;
        int i, choice;
        String name, department, position;
        switch(input){
            case 0 :
                this.status = false;
            break;
            
            case 1 :
                System.out.print("Name : ");
                name = scan.nextLine();
                
                System.out.print("Department : ");
                department = scan.nextLine();
                
                System.out.print("Position : ");
                position = scan.nextLine();
                
                Employee employee = new Employee(name, department, position);
                employeeService.create(employee);
            break;
            
            case 2:
                employees = employeeService.findAll();
                i = 1;
                
                if(employees.isEmpty()){
                    System.out.println("Database is empty...\n");
                }
                else{
                    printList(employees);
                    
                    System.out.print("Row that want to be deleted : ");
                    choice = scan.nextInt();
                    choice -= 1;
                    
                    if(choice > employees.size() || choice < 0){
                        System.out.println("Row not available...");
                    }
                    else{
                        employeeService.delete(employees.get(choice));
                    }
                }
            break;
            
            case 3 :
                employees = employeeService.findAll();
                i = 1;
                
                if(employees.isEmpty()){
                    System.out.println("Database is empty...\n");
                }
                else{
                    printList(employees);
                    
                    System.out.print("Row that want to be updated : ");
                    choice = scan.nextInt();
                    choice -= 1;
                    
                    if(choice > employees.size() || choice < 0){
                        System.out.println("Row not available...");
                    }
                    else{
                        System.out.println("Leave the value empty if the corresponding field doesnt need to be updated..");
                        
                        scan.nextLine(); //cleaning the buffer
                        
                        System.out.print("Name : ");
                        name = scan.nextLine();
                
                        System.out.print("Department : ");
                        department = scan.nextLine();

                        System.out.print("Position : ");
                        position = scan.nextLine();
                        
                        if(!name.isEmpty())
                            employees.get(choice).setName(name);
                        
                        if(!department.isEmpty())
                            employees.get(choice).setDepartment(department);
                        
                        if(!position.isEmpty())
                            employees.get(choice).setPosition(position);
                        
                        employeeService.update(employees.get(choice));
                    }
                }
            break;
            
            case 4 :
                System.out.println("Leave the value empty if the corresponding field doesnt matter..");
                        
                System.out.print("Name : ");
                name = scan.nextLine();
                
                System.out.print("Department : ");
                department = scan.nextLine();

                System.out.print("Position : ");
                position = scan.nextLine();
                
                if(name.equals("")){
                    listName = employeeService.findAll();
                }
                else{
                    listName = employeeService.findByName(name);
                }
                        
                if(department.equals("")){
                    listDepartment = employeeService.findAll();
                }
                else{
                    listDepartment = employeeService.findByDepartment(department);
                }
                
                if(position.equals("")){
                    listPosition = employeeService.findAll();
                }
                else{
                    listPosition = employeeService.findByPosition(position);
                }
                
                i = 1;
                System.out.println("Result : ");
                for(Employee e : listName){
                    if(listDepartment.contains(e) && listPosition.contains(e)){
                        System.out.print(i);
                        System.out.println(" : " + e);
                        i += 1;
                    }
                }
                
            break;
            
            case 5 :
                employees = employeeService.findAll();
                i = 1;
                
                if(employees.isEmpty()){
                    System.out.println("Database is empty...\n");
                }
                else{
                    printList(employees);
                }
                System.out.println("");
            break;
            
            case 6 :
                employeeService.deleteAll();
            break;
            
            default :
                System.out.println("Menu Not Available...\n");
        }
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    private void printList(List<Employee> list){
        int i = 1;
        
        for(Employee e : list){
            System.out.print(i);
            System.out.println(" : " + e);
            i += 1;
        }
    }
    
}
