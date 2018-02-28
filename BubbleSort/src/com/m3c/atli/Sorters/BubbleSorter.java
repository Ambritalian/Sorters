package com.m3c.atli.Sorters;

public final class BubbleSorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {
        sort(arrayToSort);
        return arrayToSort;
    }

    private void sort(int[] numbers) {
        // iterate until swaps stays true
        boolean swaps;
        do {
            swaps = true;
            for (int i=0; i<numbers.length-1; i++) {
                if (numbers[i]>numbers[i+1]) {
                    int tmp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = tmp;
                    swaps = false;
                }
            }
        } while (!swaps);
    }
}
