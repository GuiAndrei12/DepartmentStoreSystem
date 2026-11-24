/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Class representing a single node in the Binary Tree structure
 * Each node holds an Employee record and pointers to its left and right children
 * 
 * @author guilh
 */
public class TreeNode {
     
    private Employee data; //The employee data stored inside this node
    private TreeNode left; //Pointer to the left child node in the hierarchy
    private TreeNode right; //Pointer to the right child node in the hierarchy

        
    /**
     * Constructor to initialize a tree node with an Employee
     * Left and right child pointers are set to null by default
     * 
     * @param data The Employee object to store in this code
     */
    public TreeNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Getters and Setters for left and right child pointers and employee data
    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    
    
    
    
    
}
