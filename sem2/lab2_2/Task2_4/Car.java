package org.knit.sem2.lab2_2.Task2_4;

public class Car extends Thread{
    private final GasStation station;

    public Car(String name, GasStation station) {
        super(name);
        this.station = station;
    }

    @Override
    public void run() {
        station.refuel(this);
    }
}
