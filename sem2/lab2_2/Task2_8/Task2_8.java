package org.knit.sem2.lab2_2.Task2_8;

import java.util.Random;

public class Task2_8 {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        new Controller(trafficLight).start();
        Random random = new Random();

        int carNumber = 1;
        while (true) {
            new Car("Машина " + carNumber++, trafficLight).start();
            try {
                Thread.sleep(2000 + random.nextInt(3000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
