package edu.guilford;

import java.util.Arrays;
import java.util.Random;

/**
 * A class that tests the Card class.
 */

public class CardDriver {
    public static void main(String[] args) {
        // Create a new card
        Card randomCard1 = new Card();
        Card randomCard2 = new Card();
        System.out.println(randomCard1);
        System.out.println(randomCard2);

        // Compare the two cards
        int comparison = randomCard1.compareTo(randomCard2);
        if (comparison < 0) {
            System.out.println(randomCard1 + " is less than " + randomCard2);
        } else if (comparison > 0) {
            System.out.println(randomCard1 + " is greater than " + randomCard2);
        } else {
            System.out.println(randomCard1 + " is equal to " + randomCard2);
        }
        System.out.println();

        // Build a deck of cards
        Card[] deck = new Card[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(Card.Suit.values()[i / 13], Card.Rank.values()[i % 13]);
        }

        // Print the deck of cards
        System.out.println(Arrays.toString(deck));
        System.out.println();

        // Shuffle the deck of cards
        Random random = new Random();
        for (int i = 0; i < 7 * deck.length; i++) {
            int index1 = random.nextInt(deck.length);
            int index2 = random.nextInt(deck.length);
            swap(deck, index1, index2);
        }

        // Duplicate the shuffled deck of cards
        Card[] shuffledDeck = deck.clone();

        // Print the shuffled deck of cards
        System.out.println(Arrays.toString(deck));
        System.out.println();

        // Start a timer
        long startTime = System.nanoTime();

        // Sort the deck of cards
        selectionSort(deck);

        // Stop the timer
        long endTime = System.nanoTime();

        // Print the sorted deck of cards
        System.out.println(Arrays.toString(deck));
        System.out.println();

        // Print the time in seconds that it took to sort the deck of cards, formatted
        // to four decimal places
        System.out.printf("It took %.4f seconds to sort the standard deck of cards.", (endTime - startTime) * 1e-9);
        System.out.println();

        // Start a timer
        startTime = System.nanoTime();

        // Sort the shuffled deck of cards using quicksort
        quicksort(shuffledDeck);

        // Stop the timer
        endTime = System.nanoTime();

        // Print the sorted deck of cards
        System.out.println(Arrays.toString(shuffledDeck));
        System.out.println();

        // Print the time in seconds that it took to sort the deck of cards, formatted to four decimal places
        System.out.printf("It took %.4f seconds to sort the shuffled deck of cards using quicksort.",
                (endTime - startTime) * 1e-9);
        System.out.println();

        // Create a random deck of 10000 cards
        final int N = 100000;
        Card[] randomDeck1 = new Card[N];

        for (int i = 0; i < randomDeck1.length; i++) {
            randomDeck1[i] = new Card();
        }

        // Duplicate the random deck of cards
        Card[] randomDeck2 = randomDeck1.clone();

        // Start a timer
        startTime = System.nanoTime();

        // Sort the random deck of cards
        selectionSort(randomDeck1);

        // Stop the timer
        endTime = System.nanoTime();

        // Print the time in seconds that it took to sort the deck of cards, formatted
        // to four decimal places
        System.out.printf("It took %.4f seconds to sort the random deck of " + N + " cards.",
                (endTime - startTime) * 1e-9);
        System.out.println();

        // Start a timer
        startTime = System.nanoTime();

        // Sort the random deck of cards using quicksort
        quicksort(randomDeck2);

        // Stop the timer
        endTime = System.nanoTime();

        // Print the time in seconds that it took to sort the deck of cards, formatted to four decimal places
        System.out.printf("It took %.4f seconds to sort the random deck of " + N + " cards using quicksort.",
                (endTime - startTime) * 1e-9);
    }

    // Walk through the unsorted array and find the smallest card, then swap it with
    // the first card; do this until the array is sorted
    public static void selectionSort(Card[] array) {
        // The array starts out unsorted
        for (int i = 0; i < array.length - 1; i++) {
            // minIndex will be the smallest card in the unsorted part of the array
            int minIndex = i;
            // start at the rest of the unsorted part and find the smallest Card
            for (int j = i + 1; j < array.length; j++) {
                // if array[j] < array[minIndex], then array[j] is the new minimum and thus the
                // new minIndex
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j; // update the minIndex to the new minimum
                }
                // Repeat until all of the Card objects are compared
            }
            // Swap the smallest Card with the first unsorted Card
            swap(array, i, minIndex); // swap the smallest Card with the first unsorted Card
        }
    }

    // The foundation of quicksort is partitioning an array into two parts: those
    // less than
    // a pivot and those greater than a pivot. Then, you recursively quicksort the
    // two parts.
    public static int partition(Card[] array, int low, int high) {
        // low is the start of the unsorted array
        // high is the end of the unsorted array
        // find a pivot
        int pivot = (low + high) / 2;
        // Swap the pivot with the last element of the unsorted array
        swap(array, pivot, high);
        // Get the value of the pivot
        Card pivotValue = array[high];
        // Set up our pointers, one left, one right
        int leftPointer = low;
        int rightPointer = high - 1;
        // As long as the pointers haven't crossed, identify what objects need to be
        // swapped
        while (leftPointer <= rightPointer) {
            // If the left pointer is pointing to a Card that is less than the pivot, move
            // the left pointer to the right
            while (leftPointer <= rightPointer && array[leftPointer].compareTo(pivotValue) < 0) {
                leftPointer++;
                // Results in the first object that is greater than the pivot
            }
            // If the right pointer is pointing to a Card that is greater than the pivot,
            // move the right pointer to the left
            while (leftPointer <= rightPointer && array[rightPointer].compareTo(pivotValue) > 0) {
                rightPointer--;
                // Results in the first object that is less than the pivot
            }
            // If the pointers haven't crossed, swap the objects that the pointers are
            // pointing to
            if (leftPointer <= rightPointer) {
                swap(array, leftPointer, rightPointer);
                // Move the pointers to the next objects
                leftPointer++;
                rightPointer--;
            }
        }
        // When the pointers have crossed, swap the pivot with the left pointer
        swap(array, high, leftPointer);
        // After this point, the pivot is in the correct position, and we can return the
        // index of the pivot
        return leftPointer;
    }

    // The quicksort algorithm is a recursive algorithm
    // We overload the quicksort method to take an array of Card objects, which will
    // be the most common use case and the one we want to expose to the user
    public static void quicksort(Card[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(Card[] array, int low, int high) {
        // If the low index is less than the high index, then the array is not sorted
        if (low < high) {
            // Partition the array into two parts
            int pivotIndex = partition(array, low, high);
            // Recursively quicksort the left part of the array
            quicksort(array, low, pivotIndex - 1);
            // Recursively quicksort the right part of the array
            quicksort(array, pivotIndex + 1, high);
        }
    }

    public static void swap(Object[] array, int i, int j) {
        // Save array[i] in a temporary variable
        Object temp = array[i];
        // Replace array[i] with array[j]
        array[i] = array[j];
        // Replace array[j] with the original array[i], which is stored in temp
        array[j] = temp;
    }
}
