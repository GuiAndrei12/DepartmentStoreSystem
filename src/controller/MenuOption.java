/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package controller;

/**
 *
 * @author guilh
 */

//Enum representing main menu choices for terminal navigation
public enum MenuOption {
    
    SORT(1, "Sort employee list by name (Display first 20)"),
    SEARCH(2, "Search employee by name (Binary Search)"),
    ADD_RECORDS(3, "Add new employee record"),
    CREATE_BINARY_TREE(4, "Build and display Binary Tree hierarchy"),
    EXIT(5, "Exit program");
    
    private final int optionNumber;
    private final String description;
    
    //Enum constructor
    MenuOption(int optionNumber, String description) { 
        this.optionNumber = optionNumber; 
        this.description = description; 
    }
    
    public int getOptionNumber() { 
        return optionNumber; 
    }
    
    public String getDescription() { 
        return description; 
    }
    
    //Converts integer menu input to corresponding Enum constant
    public static MenuOption fromInt(int option) { 
        for (MenuOption opt : values()) { 
            if (opt.getOptionNumber() == option) { 
                return opt; 
            } 
        } 
        return null; 
    }
    
    
    
}
