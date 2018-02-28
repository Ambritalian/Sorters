package com.m3c.atli.Tools;

import com.m3c.atli.Runner.DisplayManager;

import java.util.Random;

public final class ArrayCreator {

    public static int[] createArray() {
        int size = DisplayManager.getInput();
        Random random = new Random();
        int[] newData = new int[size];
        for (int i = 0; i < size; i++)
        {
            newData[i] = random.nextInt(size*15) + 1;
        }
        return newData;
    }

    public static int[] createArray(int size) {
        Random random = new Random();
        int[] newData = new int[size];
        for (int i = 0; i < size; i++)
        {
            newData[i] = random.nextInt(size*15) + 1;
        }
        return newData;
    }


}
