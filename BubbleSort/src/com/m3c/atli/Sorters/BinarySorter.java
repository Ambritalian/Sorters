package com.m3c.atli.Sorters;

import com.m3c.atli.BinaryTree.BinarySearchTree;

import java.util.List;

public final class BinarySorter implements Sorter {

    @Override
    public int[] sortArray(int[] array) {
        if (array.length != 0) {
            BinarySearchTree bTree = new BinarySearchTree(array);
            List<Integer> list = bTree.getSortedTreeAsc();
            int i = 0;
            if (list.size() != array.length) {
                array = new int[list.size()];
            }
            for (int item : list) {
                array[i++] = item; //why does this work, and making a new array and returning that doesn't?
            }
        }
        return array;
    }
}
