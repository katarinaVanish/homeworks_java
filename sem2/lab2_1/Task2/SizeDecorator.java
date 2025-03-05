package org.knit.sem2.lab2_1.Task2;

public class SizeDecorator implements Coffee {
    protected Coffee coffee;
    private String size;

    public SizeDecorator(Coffee coffee, String size){
        this.coffee = coffee;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return size.toUpperCase() + " " + coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 20;
    }
}
