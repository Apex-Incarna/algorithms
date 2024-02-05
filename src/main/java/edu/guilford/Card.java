package edu.guilford;

import java.util.Random;

/**
 * A class to represent a playing card.
 * 
 * 
 */

// We want to sort Card objects, so the Card class must implement the Comparable
// interface

// Implementing an interface means that the class promises to provide the same
// methods as the interface being implemented

// We've acutally seen implementation before; many of our event listeners for
// our GUIs implement the ActionListener interface

// Implementing the Comparable interface means that the Card class includes a
// compareTo method that compares two Card objects and returns a distinct
// integer value
public class Card implements Comparable<Card> {
    public enum Suit {
        // enum is enumeration; it is a special type of mini-class that represents a
        // group of constants (unchangeable variables, like final variables).
        // enum can be used to create a collection of related constants.
        // it allows us to use words instead of numbers to represent a set of possible
        // values; this isn't a String standing in for an int, but a new type of data
        // for example, instead of using 0 for HEARTS, we can use Suit.HEARTS
        CLUBS, HEARTS, SPADES, DIAMONDS // these are the possible values of Suit; CLUBS is 0, HEARTS is 1, SPADES is 2,
                                        // and DIAMONDS is 3
    }

    public enum Rank {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        // attruibutes
        private int rank;

        // constructor
        private Rank(int rank) {
            this.rank = rank;
        }

        // methods
        public int getRank() {
            return rank;
        }
    }

    // Attributes
    private Suit suit; // See, enums are just like classes, so we can use them as data types for
                       // attributes
    private Rank rank;
    Random random = new Random();

    // Constructor
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Random Constructor
    public Card() {
        // Each enum has a values() method that returns an array of all the values of
        // the enum
        // So Suit.values() returns {0, 1, 2, 3}
        // And Rank.values() returns {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}
        this.suit = Suit.values()[random.nextInt(Suit.values().length)];
        this.rank = Rank.values()[random.nextInt(Rank.values().length)];
    }

    // Methods
    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card otherCard) {
        // return -1 if this card is less than otherCard
        // return 0 if this card is equal to otherCard
        // return 1 if this card is greater than otherCard

        // First, compare the suits
        if (this.suit.ordinal() < otherCard.suit.ordinal()) { // ordinal() returns the position of the enum constant
            return -1; // We ordered the suits so that the lower the ordinal, the higher the suit
                       // (CLUBS at 0 is highest, DIAMONDS at 3 is lowest)
        } else if (this.suit.ordinal() > otherCard.suit.ordinal()) {
            return 1;
        }
        // If the suits are the same, compare the ranks
        if (this.rank.getRank() > otherCard.rank.getRank()) {
            return -1;
        } else if (this.rank.getRank() < otherCard.rank.getRank()) {
            return 1;
        }
        // If the suits and ranks are the same, the cards are equal
        return 0;
    }
}
