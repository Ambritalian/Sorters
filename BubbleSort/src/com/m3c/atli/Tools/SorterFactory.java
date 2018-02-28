package com.m3c.atli.Tools;

import com.m3c.atli.Sorters.BinarySorter;
import com.m3c.atli.Sorters.BubbleSorter;
import com.m3c.atli.Sorters.MergeSorter;
import com.m3c.atli.Sorters.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class SorterFactory {

    public static String querySortType() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("resources/factory.properties"));
            String sorter = properties.getProperty("sorter");
            return sorter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Sorter getInstance() {
        switch (querySortType()) {
            case "bubble" :
                return new BubbleSorter();
            case "merge" :
                return new MergeSorter();
            case "binary" :
                return new BinarySorter();
            default :
                return new BubbleSorter();
        }
    }
}
