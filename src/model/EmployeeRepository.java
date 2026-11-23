/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author guilh
 */

//Repository class responsible for reading data, sorting, searching, and managing employees
public class EmployeeRepository {
        private ArrayList <Employee> employees; //Array list holding all loaded Employee objects in memory
        
        //List of valid departments for retail department store validation
        public static final String[] VALID_DEPARTMENTS = { 
            "Accounting", "Customer Service", "Finance", "HR",
            "IT Development", "Marketing", "Operations", "Sales", "Technical Support"
        };
        
        //Constructor
        public EmployeeRepository() {
            this.employees = new ArrayList<>();
        }
        
        //Getter to access the current list of employees and return the ArrayList of Employee objects
        public ArrayList<Employee> getEmployees() {
            return employees;
        }
        
        //Reads the Applicants_Form.txt CSV file line by line and creates Employee objects
        public void loadEmployeesFromFile(String filePath) { 
            employees.clear(); //Clear list to prevent duplicate entries if reloaded
                        
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { 
                String line;
                boolean isHeader = true;
                
                while ((line = br.readLine()) != null) {
                    
                    //Skip the first row containing CSV column names 
                    if (isHeader) { 
                        isHeader = false;
                        continue; 
                    }
                    
                    String[] data = line.split(","); //Split the comma-separated line into an array of data fields
                    
                    //Ensure the line has all required columns before processing
                    if (data.length >= 8) { 
                        String firstName = data[0].trim();
                        String lastName = data[1].trim(); 
                        String fullName = firstName + " " + lastName; 
                        String department = data[5].trim(); 
                        String position = data[7].trim(); // Job title / position 
                        
                        //Instantiate a new Employee object and store it in our list
                        Employee emp = new Employee(fullName, position, department); 
                        employees.add(emp); 
                    }
                }
                
                //Success message showing total loaded records
                System.out.println("Successfully loaded " + employees.size() + " employees from file."); 
            
            } catch (IOException e) { 
                System.out.println("Error reading file: " + e.getMessage());
            } 
        }
        
        
        
    
}
