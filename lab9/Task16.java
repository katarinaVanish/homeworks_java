package org.knit.lab9;

public class Task16 {
    enum Suit{
        DIAMONDS("бубны"),
        HEARTS("червы"),
        SPADES("пики"),
        CLUBS("треф");

        private final String suitName;

        Suit(String suitName){
            this.suitName = suitName;
        }
    }

    enum Rank{
        TWO("двойка"), THREE("тройка"), FOUR("четверка"), FIVE("пятерка"),
        SIX("шестерка"), SEVEN("семерка"), EIGHT("восьмерка"), NINE("девятка"), TEN("десятка"),
        JACK("валет"),
        QUEEN("дама"),
        KING("король"),
        ACE("туз");

        private final String rankName;

        Rank(String rankName){
            this.rankName = rankName;
        }
    }

    public static void main(String[] args){
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()) {
                System.out.println(rank.rankName + " " + suit.suitName);
            }
        }
    }
}
