package com.m3c.atli.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree implements BinaryTree {

    private int count = 0;
    private Node root;

    public BinarySearchTree(int root) {
        addElement(root);
    }

    public BinarySearchTree(int[] numbers) {
        addElements(numbers);
    }

    @Override
    public int getRootElement() {
        return root.getValue();
    }

    public Node getRootNode() {
        return root;
    }

    @Override
    public int getNumberOfElements() {
        return count;
    }

    private void addElementRecursive(int element, Node parent) {
        if (element != parent.getValue()) {
            if (element < parent.getValue()) {
                if (parent.getLeftChild() == null) {
                    Node node = new Node(element);
                    parent.setLeftChild(node);
                    count++;
                } else addElementRecursive(element, parent.getLeftChild());
            } else if (element > parent.getValue()) {
                if (parent.getRightChild() == null) {
                    Node node = new Node(element);
                    parent.setRightChild(node);
                    count++;
                } else addElementRecursive(element, parent.getRightChild());
            }
        }
    }

    @Override
    public void addElement(int element) {
        if (count == 0) {
            Node node = new Node(element);
            count++;
            this.root = node;
        } else {
            addElementRecursive(element, root);
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int i=0; i<elements.length; i++) {
            addElement(elements[i]);
        }
    }

    private Node findElementRecursive(int value, Node parent) {
        if (value < parent.getValue()) {
            if (parent.getLeftChild() == null) return null;
            else if (parent.getLeftChild().getValue() == value) return parent.getLeftChild();
            else return findElementRecursive(value, parent.getLeftChild());
        } else if (value > parent.getValue()) {
            if (parent.getRightChild() == null) return null;
            else if (parent.getRightChild().getValue() == value) return parent.getRightChild();
            else return findElementRecursive(value, parent.getRightChild());
        }
        return null;
    }

    @Override
    public boolean findElement(int value) {
        if (root.getValue() == value) return true;
        else if (findElementRecursive(value, root) == null) return false;
        else return true;
    }

    @Override
    public int getLeftChild(int element) throws ElementNotFoundException {
        Node parent;
        if (root.getValue() == element) parent = root;
        else parent = findElementRecursive(element, root);
        if (parent != null) {
            if (parent.getLeftChild() != null) return parent.getLeftChild().getValue();
            else throw new ElementNotFoundException("left child of " + element + "  not found");
        } else throw new ElementNotFoundException(element + " not found");
    }

    @Override
    public int getRightChild(int element) throws ElementNotFoundException {
        Node parent;
        if (root.getValue() == element) parent = root;
        else parent = findElementRecursive(element, root);
        if (parent != null) {
            if (parent.getRightChild() != null) return parent.getRightChild().getValue();
            else throw new ElementNotFoundException("right child of " + element + "  not found");
        } else throw new ElementNotFoundException(element + " not found");
    }

    @Override
    public List<Integer> getSortedTreeAsc() {
        List<Integer> sortedTree = new ArrayList<>();
        ascOrder(root, sortedTree);
        return sortedTree;
    }

    @Override
    public List<Integer> getSortedTreeDesc() {
        List<Integer> sortedTree = new ArrayList<>();
        descOrder(root, sortedTree);
        return sortedTree;
    }

    private void ascOrder(Node parent, List<Integer> sortedTree) {
        if (parent.getLeftChild() != null) {
            ascOrder(parent.getLeftChild(), sortedTree);
            sortedTree.add(parent.getValue());
        }
        if (parent.getLeftChild() == null) {
            sortedTree.add(parent.getValue());
        }
        if (parent.getRightChild() != null) {
            ascOrder(parent.getRightChild(), sortedTree);
        }
    }

    private void descOrder(Node parent, List<Integer> sortedTree) {
        if (parent.getRightChild() != null) {
            descOrder(parent.getRightChild(), sortedTree);
            sortedTree.add(parent.getValue());
        }
        if (parent.getRightChild() == null) {
            sortedTree.add(parent.getValue());
        }
        if (parent.getLeftChild() != null) {
            descOrder(parent.getLeftChild(), sortedTree);
        }
    }

}
