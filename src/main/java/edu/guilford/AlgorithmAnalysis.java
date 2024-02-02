package edu.guilford;

import java.util.Random;

public class AlgorithmAnalysis {
    public static void main(String[] args) {
        // Rewrite the following method to time and compare the static selectionSort method from the SelectionSort class and the static quicksort method from the Quicksort class.
        // The method should take an integer array as an argument and return the time in seconds it takes to sort the array using each algorithm.
        // The method should also print the time in seconds it takes to sort the array using each algorithm.

        // Create an array of 100,000 random integers
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        // Time and compare the static selectionSort method from the SelectionSort class and the static quicksort method from the Quicksort class
        long startTime = System.nanoTime();
        SelectionSort.selectionSort(array);
        long endTime = System.nanoTime();

        long selectionSortTime = (endTime - startTime) / 1000000000;
        System.out.println("Selection sort time: " + selectionSortTime + " seconds");

        startTime = System.nanoTime();
        Quicksort.quicksort(array);
        endTime = System.nanoTime();

        long quicksortTime = (endTime - startTime) / 1000000000;
        System.out.println("Quicksort time: " + quicksortTime + " seconds");

        
    }
}