/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treemain;

/**
 *
 * @author 91987
 */
public class BST {

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

        private int getheight(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
    private Node root;

    public void inOrderTraversal() {
        System.out.println("InOrder Traversal :");
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.value + " Height of node: " + node.height);
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
            populate(value, root);
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

        return node;
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
