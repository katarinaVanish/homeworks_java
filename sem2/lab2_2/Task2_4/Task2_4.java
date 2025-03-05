package org.knit.sem2.lab2_2.Task2_4;

public class Task2_4 {
    public static void main(String[] args) {
        GasStation station = new GasStation();
        for (int i = 1; i <= 5; i++) { 
            new Car("Машина " + i, station).start();
        }
    }

}
