package com.iamstupendous;

import org.junit.Test;

public class QuickSortTest {
    @Test
    public void sort3NumbersTest() {
        var quicksort = new QuickSort();
        quicksort.sort(new long[] {11L, 9L, 5L});
        //quicksort.printArray();
    }

    @Test
    public void sort5NumbersTest() {
        var quicksort = new QuickSort();
        quicksort.sort(new long[] {6L, 3L, 5L, 9L, 8L});
        //quicksort.printArray();
    }
}
