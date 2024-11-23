package org.knit.lab9;

public class Task16 {
    enum Suit{
        DIAMONDS("бубны"),
        HEARTS("червы"),
        SPADES("пики"),
        CLUBS("трефы");

        private final String suitName;

        Suit(String suitName){
            this.suitName = suitName;
        }
    }

    enum Rank{
        DIGIT(),
        JACK,
        QUEEN,
        KING,
        ACE;

    }
}
