/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Employee;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guilh
 */
public class ConsoleView {
    
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    
    //Displays the main menu options to the user
    public void displayMenu() {
        System.out.println("\\n==================================================");
        System.out.println(" DEPARTMENT STORE MANAGEMENT SYSTEM ");
        System.out.println("==================================================");
        System.out.println(" 1. SORT - Sort Employees Alphabetically (QuickSort)");
        System.out.println(" 2. SEARCH - Search Employee by Name (Binary Search)");
        System.out.println(" 3. ADD_RECORDS - Add New Employee Record");
        System.out.println(" 4. BINARY_TREE - Display Organizational Chart (Level-Order)");
        System.out.println(" 5. EXIT - Exit Program");
        System.out.println("==================================================");
        System.out.print("Select an option (1-5): "); 
    }
    
    public int readOption() {
        
        try {
            String input = scanner.nextLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; //Retorna opção inválida caso não seja número 
        }
    }
    
    //Displays a list of employees in a formatted table layout
    public void displayEmployees(List<Employee> employees, int limit) {
        
        if (employees == null || employees.isEmpty()) {
            System.out.println("\n[!] No employee records available.");
            return;
        }
        
        int count = (limit > 0 && limit < employees.size()) ? limit : employees.size();
        
        System.out.println("\\n----------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-30s | %-25s | %-15s%n", "No.", "NAME", "POSITION", "DEPARTMENT");
        System.out.println("----------------------------------------------------------------------------------");
        
        for (int i = 0; i < count; i++) {
            
            Employee emp = employees.get(i);
            System.out.printf("%-5d | %-30s | %-25s | %-15s%n",
                    (i + 1),
                    emp.getName(),
                    emp.getPosition(),
                    emp.getDepartment());           
        }
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Showing " + count + " of " + employees.size() + " total records.");
    
    }
    
    //Ask the user to enter a name for Binary Search
    public String readSearchName() {
        System.out.print("\\nEnter employee name to search: ");
        return scanner.nextLine().trim();
    }
    
    //Ask the user for new employee details (Name, Position, Department)
    public String[] readNewEmployeeDetails() {
        
        System.out.println("\\n--- ADD NEW EMPLOYEE ---");
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Position: ");
        String position = scanner.nextLine().trim();
        
        System.out.print("Enter Department: ");
        String department = scanner.nextLine().trim();
        
        return new String[]{name, position, department};
    }
    
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
