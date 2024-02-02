package edu.guilford;

/**
 * The Quicksort class features a static method that sorts an array of integers using the quicksort algorithm.
 */

public class Quicksort {
    /**
     * Sorts an array of integers using the quicksort algorithm.
     * 
     * @param array the array of integers to be sorted
     * @return the sorted array of integers
     */
    public static int[] quicksort(int[] array) {
        // Pick a pivot element
        int pivot = array[array.length / 2];
        int i, j;
        for (i = 0, j = array.length - 1; ; i++, j--) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        // Recursively sort the sub-arrays to the left and right of the pivot
        if (i > 1) {
            int[] leftArray = new int[i];
            for (int k = 0; k < i; k++) {
                leftArray[k] = array[k];
            }
            leftArray = quicksort(leftArray);
            for (int k = 0; k < i; k++) {
                array[k] = leftArray[k];
            }
        }
        if (array.length - i > 1) {
            int[] rightArray = new int[array.length - i];
            for (int k = 0; k < array.length - i; k++) {
                rightArray[k] = array[i + k];
            }
            rightArray = quicksort(rightArray);
            for (int k = 0; k < array.length - i; k++) {
                array[i + k] = rightArray[k];
            }
        }
        return array;
    }
}
