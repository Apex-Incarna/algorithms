package edu.guilford;

/**
 * The SelectionSort class features a static method that sorts an array of integers using the selection sort algorithm.
 */

public class SelectionSort {
    /**
     * Sorts an array of integers using the selection sort algorithm.
     * 
     * @param array the array of integers to be sorted
     * @return the sorted array of integers
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
    
}
