/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treemain;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author 91987
 */
public class Tree {

    private Node root;

    public void insert(Scanner sc) {
        System.out.println("please eneter the root of the TREE");
        int val = sc.nextInt();
        root = new Node(val);
        insertNext(sc, root);
    }

    public void insertNext(Scanner sc, Node node) {
        boolean right;
        int rightVal;
        boolean left;
        int leftVal;
        System.out.println("Do you want to add in left of " + node.value);
        left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value of left node");
            leftVal = sc.nextInt();
            Node node1 = new Node(leftVal);
            node.left = node1;
            insertNext(sc, node1);
        }

        System.out.println("Do you want to add in right of " + node.value);
        right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value of right node");
            rightVal = sc.nextInt();
            Node node1 = new Node(rightVal);
            node.right = node1;
            insertNext(sc, node1);
        }
    }
    
    public void preOrderTraversal(){
        System.out.println("PreOrder Traversal :");
        preOrder(root);
    }
    
    public void preOrder(Node node){
         if(node == null){
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);     
        preOrder(node.right);
    }
    public void inOrderTraversal(){
        System.out.println("InOrder Traversal :");
        inOrder(root);
    }
    
    public void inOrder(Node node){
         if(node == null){
            return;
        }
       
        inOrder(node.left);
        System.out.println(node.value);      
        inOrder(node.right);
    }
    public void postOrderTraversal(){
        System.out.println("PostOrder Traversal :");
        postOrder(root);
    }
    
    public void postOrder(Node node){
         if(node == null){
            return;
        }
       
        postOrder(node.left);      
        postOrder(node.right);
        System.out.println(node.value);
    }

    private class Node {

        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }
    
    public Node createtree(int[] inOrder, int[] preOrder){
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        
        int[] index = {0};
        
        return createtree(inOrder,preOrder,0,0,map,index);
    }
    
    public Node createtree(int[] inOrder, int[] preOrder,int left , int right , HashMap<Integer,Integer> map,int[] index){
        if(left > right){
            return null;
        }
        int value = preOrder[index[0]];
        index[0]++;
        Node node = new Node(value);
        
        if(left == right){
            return node;
        }
        
        int currentindex = map.get(value);
        
        node.left = createtree(inOrder,preOrder,left,currentindex -1,map,index);
        node.left = createtree(inOrder,preOrder,currentindex+1,right,map,index);
        
        
        return node;
    }
        
}
