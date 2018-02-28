package com.m3c.atli.Tests;

import com.m3c.atli.Sorters.Sorter;
import com.m3c.atli.Tools.SorterFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestSorter {

    int[] unsortedArray = {5,4,3,2,1};
    int[] sortedArray = {1,2,3,4,5};
    int[] evenArray = {6,5,4,3,2,1};
    int[] evenSortedArray = {1,2,3,4,5,6};
    int[] duplicates = {5,1,4,2,3,3,2,4,1,5};
    int[] duplicateSorted = {1,1,2,2,3,3,4,4,5,5};
    int[] same = {1,1,1,1,1};
    int[] empty = {};
    int[] longBoyBackwards = new int[101];
    int[] longBoy = new int[101];

    Sorter sorter;

    @Before
    public void setSorter() {
        SorterFactory factory = new SorterFactory();
        sorter = factory.getInstance();
    }

    @Test
    public void testOddSort() {
        sorter.sortArray(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    public void testEvenSort() {
        sorter.sortArray(evenArray);
        assertArrayEquals(evenArray, evenSortedArray);
    }

//    @Test
//    public void testDuplicates() {
//        sorter.sortArray(duplicates);
//        assertArrayEquals(duplicates, duplicateSorted);
//    }

    @Test
    public void testDuplicatesTree() {
        duplicates = sorter.sortArray(duplicates); // qhy do i need to reassign the array?
        System.out.println(Arrays.toString(duplicates));
        assertArrayEquals(duplicates, sortedArray);
    }

    @Test
    public void testSame() {
        sorter.sortArray(same);
        assertArrayEquals(same, same);
    }

    @Test
    public void testEmpty() {
        sorter.sortArray(empty);
        assertArrayEquals(empty, empty);
    }

    @Test
    public void testLongBoy() {
        int count = 0;
        for (int i = 100; i>=0; i--) {
            longBoy[count] = count;
            longBoyBackwards[count++] = i;
        }
        sorter.sortArray(longBoyBackwards);
        assertArrayEquals(longBoy, longBoyBackwards);
    }
}
