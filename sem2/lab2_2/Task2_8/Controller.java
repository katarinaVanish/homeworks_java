package org.knit.sem2.lab2_2.Task2_8;

public class Controller extends Thread{
    private final TrafficLight trafficLight;

    public Controller(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        while (true) {
            trafficLight.changeLight(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            trafficLight.changeLight(false);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
