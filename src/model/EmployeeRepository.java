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
        
        /**
         * Recursive QuickSort algorithm to sort employees by name alphabetically
         */
        public void sortEmployeesByName() { 
            if (employees.size() > 1) { 
                quickSort(0, employees.size() - 1); //Kick off recursive sorting from index 0 to the last element index
            } 
        }
                
        /**
         * Recursive QuickSort function using Divide and Conquer technique.
         *
         * @param low Starting index of the sub-array to sort 
         * @param high Ending index of the sub-array to sort 
         */
        private void quickSort(int low, int high) { 
            if (low < high) { //Stop when sub-array has 0 or 1 element
                int pivotIndex = partition(low, high); //Rearrange elements around pivot and get pivot's final sorted index
                quickSort(low, pivotIndex - 1); // Sort elements on the left of the pivot 
                quickSort(pivotIndex + 1, high); // Sort elements on the right of the pivot 
            } 
        }
        
        /**
         * Partition helper method (Lomuto Partition Scheme)
         * Chooses the last element as pivot, places smaller elements to its left and larger elements to its right
         * @param low Lower bound index
         * @param high Upper bound index (pivot position)
         * @return Final index position where pivot is now correctly placed
         */
        private int partition(int low, int high) { 
            String pivot = employees.get(high).getName(); //Pick the last employee's name in current range as pivot
            int i = low - 1;
            
            //Compare each element with the pivot
            for (int j = low; j < high; j++) { 
                //Compare names alphabetically ignoring case (A-Z order)
                //If current name comes before or is equal to pivot name, swap objects
                if (employees.get(j).getName().compareToIgnoreCase(pivot) <= 0){ 
                    i++;
                    
                    // Swap employees[i] and employees[j] 
                    Employee temp = employees.get(i); 
                    employees.set(i, employees.get(j)); 
                    employees.set(j, temp); 
                } 
            }

            // Final step: Swap pivot (at index high) with element at position (i + 1) 
            // Places pivot in its correct sorted position in the list 
            Employee temp = employees.get(i + 1); 
            employees.set(i + 1, employees.get(high)); 
            employees.set(high, temp);
            
            
            //Return the correct index position where pivot now resides
            return i + 1;
        }
        
        /**
         * Recursive Binary Search algorithm to search for an employee by full name
         * Ensures the list is sorted first, which is a mandatory requirement for Binary Search
         * 
         * @param targetName The full name of the employee to look up
         * @return Employee object if found, or null if no match exists 
         */
        public Employee searchEmployeeByName(String targetName) {
        
            //Ensure list is sorted before performing Binary Search
            sortEmployeesByName();
            
            //Execute recursive binary search across the full array range
            int index = binarySearchRecursive(0, employees.size() - 1, targetName.trim());
            
            //If index is not -1, it means the employee was found in the list
            if (index != -1) {
                return employees.get(index);
            }
            return null;
        
        }
        
        /**
         * Recursive Binary Search implementation (Divide and Conquer strategy)
         * Compares the target name against the middle element and cuts the search space in half
         * 
         * @param left Starting index boundary
         * @param right Ending index boundary
         * @param targetName Name we are searching for
         * @return Index position of found employee, or -1 if not found
         */
        private int binarySearchRecursive(int left, int right, String targetName) { 
            if (left > right) { 
                return -1; //Element not found 
            }
            
            //Calculate middle index position
            int mid = left + (right - left) / 2;
            
            //Get the employee name at the middle position
            String midName = employees.get(mid).getName();
            
            //Compare target name with middle name alphabetically (case-insensitive)
            int comparison = targetName.compareToIgnoreCase(midName);
            
            if (comparison == 0) { 
                return mid; //Target found at index mid
            } else if (comparison < 0) { 
                return binarySearchRecursive(left, mid - 1, targetName); //Search left half 
            } else { 
                return binarySearchRecursive(mid + 1, right, targetName); //Search right half 
            } 
        }
        
        /**
         * Validates if a department exists in the official valid list
         */
        public boolean isValidDepartment(String department) { 
            for (String validDept : VALID_DEPARTMENTS) { 
                if (validDept.equalsIgnoreCase(department.trim())) { 
                    return true; 
                } 
            } 
            return false; 
        }
        
        /**
         * Adds a new employee record after validating input
         */
        public boolean addEmployee(Employee newEmp) { 
            if (isValidDepartment(newEmp.getDepartment())) { //Ensure department is valid before inserting record
                employees.add(newEmp); 
                return true; 
            } 
            return false; 
        }
        
        
    
}
