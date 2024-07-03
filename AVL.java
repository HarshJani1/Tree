/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treemain;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author 91987
 */
public class AVL {

    private class Node {

        int value;
        Node left;
        Node right;
        int height;

        private Node() {

        }

        private Node(int value) {
            this.value = value;
        }

        

    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    
    public Node root;

    public void inOrderTraversal() {
        System.out.println("InOrder Traversal :");
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.value+" "+node.height);
        inOrder(node.right);
    }

    private boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        if (root == null) {
            Node node = new Node(value);
            root = node;
        } else {
          root =  populate(value, root);
        }
    }

    private Node populate(int value, Node node) {
        if (node == null) {
            Node node1 = new Node(value);
            return node1;
        }

        if (value < node.value) {
            node.left = populate(value, node.left);
        }
        if (value > node.value) {
            node.right = populate(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return balance(node);
    }
    
    private Node balance(Node node){
        
        if( height(node.left) - height(node.right) < -1){
            
            if(height(node.right.left) - height(node.right.right) < 0){
                
                return leftRotation(node);
                
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                
                node = rightLeftRotation(node);
                return leftRotation(node);
                
            }           
            
        }
        
        if( height(node.left) - height(node.right) > 1){
            
            if(height(node.right.left) - height(node.right.right) < 0){
                
                node = leftRightRotation(node);
                return rightRotation(node);
                
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                
                return rightRotation(node);
                
            }           
            
        }
        
        
        return node;
    }
    
    private Node leftRotation(Node node){
        Node a = node;
        Node b = node.right;
        
        b.left = a;
        a.right = null;
        
        return b;
    }
    
    private Node rightRotation(Node node){
        Node a = node;
        Node b = node.left;
        
        b.right = a;
        a.left = null;
        
        return b;
    }
    
    private Node rightLeftRotation(Node node){
        Node a = node;
        Node b = a.right;
        Node c = b.left;
        
        a.right = c;
        c.right = b;
        b.left = null;
        
        return a;
    }
    
    private Node leftRightRotation(Node node){
        Node a = node;
        Node b = node.left;
        Node c = b.right;
        
        a.left = c;
        c.left = b;
        b.right = null;
        
        return a;
        
    }
    

    public boolean isBalanced() {
        if (root == null) {
            return true;
        }
        return checkBalance(root);
    }

    private boolean checkBalance(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && checkBalance(node.left) && checkBalance(node.right);

    }
    
    
    
     

}
