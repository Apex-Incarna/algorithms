package edu.guilford;

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
    }
}
