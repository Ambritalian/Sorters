package com.m3c.atli.Tests;

import com.m3c.atli.BinaryTree.BinarySearchTree;
import com.m3c.atli.BinaryTree.ElementNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class TestTree {

    int[] arr = {7, 2, 4, 1, 10, 11, 12, 5, 6, 14 , 13, 10, 11, 12};
    BinarySearchTree btree;

    @Before
    public void treeMaker() {
        btree = new BinarySearchTree(arr);
    }

    @Test
    public void testRoot() {
        assertTrue(btree.getRootElement() == 7);
        assertFalse(btree.getRootElement() == 6);
    }

    @Test
    public void testNumElements() {
        assertTrue(arr.length != btree.getNumberOfElements());
        assertTrue(11 == btree.getNumberOfElements());
        assertFalse(arr.length == btree.getNumberOfElements());
        assertFalse(12 == btree.getNumberOfElements());
    }

    @Test
    public void testAddElement() {
        // create a new tree and check the root
        BinarySearchTree bst = new BinarySearchTree(2);
        assertTrue(bst.getRootElement() == 2);
        assertFalse(bst.getRootElement() == 6);
        // check position of added element
        bst.addElement(1);
        assertTrue(bst.getRootNode().getLeftChild() != null);
        assertFalse(bst.getRootNode().getRightChild() != null);
        assertEquals(1, bst.getRootNode().getLeftChild().getValue());
        // check multiple children
        bst.addElement(3);
        assertTrue(bst.getRootNode().getRightChild() != null);
        assertFalse(bst.getRootNode().getLeftChild() == null);
        assertEquals(3, bst.getRootNode().getRightChild().getValue());
        // check grandchildren & duplication
        bst.addElement(2);
        bst.addElement(3);
        bst.addElement(1);
        bst.addElement(4);
        bst.addElement(4);
        assertTrue(bst.getRootNode().getRightChild().getRightChild() != null);
        assertTrue(bst.getRootNode().getRightChild().getLeftChild() == null);
        assertEquals(4, bst.getRootNode().getRightChild().getRightChild().getValue());
        assertEquals(4, bst.getNumberOfElements());
    }

    @Test
    public void testFindElement() {
        // check root is found
        assertTrue(btree.findElement(7));
        // check left child & right child are found
        assertTrue(btree.findElement(2));
        assertTrue(btree.findElement(10));
        // check distant relatives are found
        assertTrue(btree.findElement(6));
        assertTrue(btree.findElement(13));
        // check non existent entries are not found
        assertFalse(btree.findElement(35));
        assertFalse(btree.findElement(19));
    }

    @Rule public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testGetLeftChildFails() throws ElementNotFoundException {
        thrown.expect(ElementNotFoundException.class);
//        btree.getLeftChild(60);
        btree.getLeftChild(12);
    }

    @Test
    public void testLeftChild() throws ElementNotFoundException{
        System.out.println(btree.getLeftChild(14));
    }

    @Test
    public void testRightChild() throws ElementNotFoundException{
        System.out.println(btree.getRightChild(5));
    }

    @Test
    public void testGetRightChildFails() throws ElementNotFoundException {
        thrown.expect(ElementNotFoundException.class);
        //btree.getRightChild(61);
        btree.getRightChild(14);
    }

    @Test
    public void testSortAsc() {
        List<Integer> list = btree.getSortedTreeAsc();
        //test size of list (and hence tree) against correct array size
        assertEquals(11, list.size());
        int sum = 0;
        int last = 0;
        boolean smaller = true;
        for (int item : list) {
            if (last > item) smaller = false;
            last = item;
            sum = sum + item;
        }
        // check that numbers havent changed during sorting
        assertEquals(85, sum);
        // check ascending order
        assertTrue(smaller);
    }

    @Test
    public void testSortDesc() {
        List<Integer> list = btree.getSortedTreeDesc();
        assertEquals(11, list.size());
        int sum = 0;
        int last = 15;
        boolean larger = true;
        for (int item : list) {
            if (last < item) larger = false;
            last = item;
            sum = sum + item;
        }
        assertEquals(85, sum);
        assertTrue(larger);
    }
}



