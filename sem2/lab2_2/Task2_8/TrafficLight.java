package org.knit.sem2.lab2_2.Task2_8;

public class TrafficLight {
    private boolean isGreen = true;

    public synchronized void waitForGreen() {
        while (!isGreen) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " проезжает перекресток.");
    }

    public synchronized void changeLight(boolean green) {
        isGreen = green;
        if (isGreen) {
            System.out.println("Светофор: ЗЕЛЕНЫЙ - Машины могут ехать.");
            notifyAll();
        } else {
            System.out.println("Светофор: КРАСНЫЙ - Машины останавливаются.");
        }
    }
}
