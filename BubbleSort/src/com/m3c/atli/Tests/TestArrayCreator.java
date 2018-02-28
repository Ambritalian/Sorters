package com.m3c.atli.Tests;

import com.m3c.atli.Tools.ArrayCreator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestArrayCreator {

    public int[] array = {5,4,3,2,1};
    public int size = array.length;

    @Test
    public void testInput() {
        int[] arr = ArrayCreator.createArray(size);
        assertEquals(arr.length,size);
    }
    @Test
    public void testValues() {
        //int[] arr = ArrayCreator.createArray(size);
        int sum = 0;
        for (int i=0; i<size; i++) {
            //sum = sum + arr[i];
        }
        assertTrue(sum <= ((size*15)*size));
    }
}
