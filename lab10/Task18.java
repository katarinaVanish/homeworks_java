package org.knit.lab10;

public class Task18 {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 30);

        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

        pair.setSecond(35);
        System.out.println(pair.getSecond());
    }
}
