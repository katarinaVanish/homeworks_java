package org.knit.sem2.lab2_1.Task2;

public class Caramel implements Coffee {
    protected Coffee coffee;

    public Caramel(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", карамель";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.75;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 60;
    }
}
