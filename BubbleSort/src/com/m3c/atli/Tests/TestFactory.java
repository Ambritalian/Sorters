package com.m3c.atli.Tests;

import com.m3c.atli.Sorters.BubbleSorter;
import com.m3c.atli.Sorters.Sorter;
import com.m3c.atli.Tools.SorterFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFactory {

    @Test
    public void testProperties() {
        String expectedProperty = "bubble";
        String actualProperty = SorterFactory.querySortType();
        assertEquals(actualProperty,expectedProperty);
        assertFalse(actualProperty == "binary");
    }

    @Test
    public void testEmpty() {
        String expectedProperty = "";
        String actualProperty = SorterFactory.querySortType();
        assertFalse(actualProperty == expectedProperty);
    }

    @Test
    public void testCases() {
        String expectedProperty = "Bubble";
        String actualProperty = SorterFactory.querySortType();
        assertFalse(actualProperty == expectedProperty);
    }

    @Test
    public void testInstance() {
        Sorter sorter = SorterFactory.getInstance();
        assertFalse(sorter.getClass() != BubbleSorter.class);
    }
}
