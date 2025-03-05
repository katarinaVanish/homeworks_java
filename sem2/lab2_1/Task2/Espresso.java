package org.knit.sem2.lab2_1.Task2;

public class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Эспрессо";
    }

    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public int getCalories() {
        return 5;
    }
}
