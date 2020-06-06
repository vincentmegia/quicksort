package com.iamstupendous;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    private long[] sorted = new long[]{};
    /**
     * Sorts the array using simple Quicksort algo
     */
    public void sort(long[] array) {
        var partitionIndex = sortInternal(array);
        partitionAndSort(array, partitionIndex);
    }

    public long[] partitionAndSort(long[] array, int partitionIndex) {
        var list = new ArrayList<long[]>();
        var partition = Arrays.copyOfRange(array, 0, partitionIndex);
        list.add(partition);
        partition = Arrays.copyOfRange(array, partitionIndex, array.length);
        list.add(partition);
        for (var item: list) {
            if (item.length <= 1) {
                this.sorted = ArrayUtils.addAll(this.sorted, item);
                continue;
            }
            if (item.length == 2) {
                if (item[0] > item[1])
                    item = new long[] {item[1], item[0]};
                this.sorted = ArrayUtils.addAll(this.sorted, item);
                continue;
            }
            var newPartitionIndex = sortInternal(item);
            partitionAndSort(item, newPartitionIndex);
            this.sorted = ArrayUtils.addAll(this.sorted, item);
        }
        return this.sorted;
    }

    /**
     * actual sort implementation
     * @param array
     * @return returns the index of the sorted element or partition
     */
    public int sortInternal(long[] array) {
        var pivot = array[0];
        var i = 0;
        var j = array.length;
        while(j > i) {
            //find element > pivot
            while (!(++i >= array.length - 1 || array[i] > pivot)) {
            }
            while (!(--j <= 0 || j > i || array[j] < pivot)) {
            }
            swap(array, 0, j); //last step is to swap pivot and j
        }
        return j == 0 ? 1 : j;
    }

    /**
     * Swap elements
     * @param array
     * @param x
     * @param y
     */
    public void swap(long[] array, int x, int y) {
        var temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
