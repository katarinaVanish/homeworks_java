package org.knit.sem2.lab2_1.Task2;

public class Chocolate implements Coffee {
    protected Coffee coffee;

    public Chocolate(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", шоколад";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 80;
    }
}
