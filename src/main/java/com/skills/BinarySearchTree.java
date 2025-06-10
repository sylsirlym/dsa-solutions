package com.skills;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 22:43
 */
public class BinarySearchTree {
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {  // Require data at construction
            this.data = data;
        }
    }

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(Node node, int min, int max) {
        if (node == null) return true;

        // Check current node's data is within bounds
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // For left subtree, max becomes current node's data
        // For right subtree, min becomes current node's data
        return checkBST(node.left, min, node.data)
                && checkBST(node.right, node.data, max);
    }
}
