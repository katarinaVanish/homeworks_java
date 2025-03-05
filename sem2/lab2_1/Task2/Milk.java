package org.knit.sem2.lab2_1.Task2;

public class Milk implements Coffee {
    protected Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", молоко";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 50;
    }
}
