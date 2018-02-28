package com.m3c.atli.Runner;

import com.m3c.atli.Tools.ArrayCreator;
import com.m3c.atli.Sorters.Sorter;
import com.m3c.atli.Tools.SorterFactory;

final class SortManager {

    public void sortArray() {
        int[] numbers = ArrayCreator.createArray();
        DisplayManager.printArray(numbers, "Unsorted");
        Sorter sorter = SorterFactory.getInstance();
        long start = System.nanoTime();
        sorter.sortArray(numbers);
        long end = System.nanoTime();
        DisplayManager.printTimeDifference(start, end, SorterFactory.querySortType());
        DisplayManager.printArray(numbers,"Sorted");
    }

}
