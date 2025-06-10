package com.skills;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 23:03
 */
public class BinarySearchTreeTest {
    @Test
    public void testValidBST() {
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = new BinarySearchTree.Node(5);
        root.left = new BinarySearchTree.Node(3);
        root.right = new BinarySearchTree.Node(7);
        assertTrue(bst.checkBST(root));
    }

    @Test
    public void testInvalidBST() {
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = new BinarySearchTree.Node(5);
        root.left = new BinarySearchTree.Node(6);  // Invalid left child
        root.right = new BinarySearchTree.Node(7);
        assertFalse(bst.checkBST(root));
    }

    @Test
    public void testDuplicateValues() {
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = new BinarySearchTree.Node(5);
        root.left = new BinarySearchTree.Node(5);  // Depending on BST definition
        assertFalse(bst.checkBST(root)); // Fails because we used >= and <=
    }
}
