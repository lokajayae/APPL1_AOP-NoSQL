/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Evan Lokajaya
 */

@Document(collection = "employee")
public class Employee {
    @Id
    private String _id;
    
    private String name;
    private String department;
    private String position;
    
    public Employee(String name, String department, String position){
        super();
        this.name = name;
        this.department = department;
        this.position = position;
    }
    
    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Id : " + getId() + ", Name : " + getName() + ", Department : " + getDepartment() + ", Position : " + getPosition());
        return str.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        
        if (!(o instanceof Employee)) { 
            return false; 
        }
        
        Employee e = (Employee) o;
        return name.equals(e.getName()) &&
                department.equals(e.getDepartment()) &&
                position.equals(e.getPosition());
    }
}
