/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author guilh
 */

//Model class representing an employee/applicant in the Department Store system.
public class Employee {
    
    private String name;
    private String position;
    private String department;

    //Constructor
    public Employee(String name, String managerType, String department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    //Formatted String representation for terminal display
    @Override
    public String toString() {
        return String.format("Name: %-22s | Position: %-20s | Dept: %-15s", name, position, department);
    }
    
}
