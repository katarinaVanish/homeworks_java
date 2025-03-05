package org.knit.sem2.lab2_2.Task2_6;

import java.util.ArrayList;
import java.util.List;

public class RailwayCrossing {
    private boolean trainApproaching = false;
    private final List<String> waitingCars = new ArrayList<>();

    public synchronized void waitForTrain(String carName) {
        while (trainApproaching) {
            waitingCars.add(carName);
            System.out.println("Остановились: " + waitingCars);
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            waitingCars.remove(carName);
        }
        System.out.println(carName + " проезжает переезд и уезжает.");
    }

    public synchronized void trainArrives() {
        System.out.println("Поезд приближается!");
        trainApproaching = true;
    }

    public synchronized void trainDeparts() {
        System.out.println("Поезд уехал! Машины могут двигаться.");
        trainApproaching = false;
        notifyAll();
    }
}
