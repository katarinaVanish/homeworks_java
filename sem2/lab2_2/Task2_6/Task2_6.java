package org.knit.sem2.lab2_2.Task2_6;

import java.util.Random;

@TaskDescription(6, "Железнодорожный переезд");
/*
Есть автомобили и поезд.
- Если поезд приближается, машины останавливаются и ждут.
- После того, как поезд проедет, машины продолжают движение.
*/

public class Task2_6 {
    public static void main(String[] args) {
        RailwayCrossing crossing = new RailwayCrossing();
        new Train(crossing).start();
        Random random = new Random();
        int carNumber = 1;
        while (true) {
            new Car("Машина " + carNumber++, crossing).start();
            try {
                Thread.sleep(2000 + random.nextInt(3000)); // задержка
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
