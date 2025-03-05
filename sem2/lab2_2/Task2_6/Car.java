package org.knit.sem2.lab2_2.Task2_6;

public class Car extends Thread{
    private final RailwayCrossing crossing;

    public Car(String name, RailwayCrossing crossing) {
        super(name);
        this.crossing = crossing;
    }

    @Override
    public void run() {
        crossing.waitForTrain(getName());
    }
}
