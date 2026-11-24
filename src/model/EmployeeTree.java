/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class representing the Binary Tree structure for managing the employee hierarchy
 * Implements Level-Order insertion and Breadth-First Search traversal
 * 
 * @author guilh
 */
public class EmployeeTree {
    
    private TreeNode root; //Root node of the binary tree (top of the hierarchy)

    //Constructor to initialize an empty EmployeeTree
    public EmployeeTree() {
        this.root = null;
    }
   
    //Getter for the root node of the tree
    public TreeNode getRoot() {
        return root;
    }
    
    // Builds a complete Binary Tree level-by-level from a given list of employees using a Queue
    public void buildTreeFromList(List<Employee> employees) {
        this.root = null; // Reset root to ensure fresh tree building
        
        if (employees == null || employees.isEmpty()) {
            return;
        }
        
        //Queue to keep track of parent nodes awaiting child insertion
        Queue<TreeNode> queue = new LinkedList<>();
        
        //1. First employee becomes the root of the hierarchy
        this.root = new TreeNode(employees.get(0));
        queue.add(this.root);
        
        //2. Iterate through remaining employees and insert them in level order
        int i = 1;
        while (i < employees.size() && !queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            //Insert left child if an employee is available
            if (i < employees.size()) {
                current.setLeft(new TreeNode(employees.get(i)));
                queue.add(current.getLeft());
                i++;
            }
            
            //Insert right child if an employee is available
            if (i < employees.size()) {
                current.setRight(new TreeNode(employees.get(i)));
                queue.add(current.getRight());
                i++;    
            }
            
        }  
    
    }
    
    /**
     * Traverses and prints the Binary Tree in Level-Order (Breadth-First Search)
     * Displays each level of the store organizational chart in the console
     * 
     */
    public void printLevelOrder() {
        if (root == null) {
            System.out.println("The organizational tree is empty.");
            return;       
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 1;
        System.out.println("\n==================================================");
        System.out.println("DEPARTMENT STORE ORGANIZATIONAL CHART");
        System.out.println("==================================================");
        
        //Process nodes level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.println("\n--- Level " + level + " ---");
            
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.println(" └─ " + current.getData().toString());
                
                //Enqueue left and right children for the next level
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }   
                
            }
            
            level++;
        
        }
        
        System.out.println("==================================================\n");
    
    }
    
}
