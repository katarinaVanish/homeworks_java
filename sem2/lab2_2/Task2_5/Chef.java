package org.knit.sem2.lab2_2.Task2_5;

import java.util.Random;

class Chef extends Thread {
    private final Restaurant restaurant;
    private final Random random = new Random();

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        int dishNumber = 1;
        while (true) {
            restaurant.cook("Блюдо " + dishNumber++);
            try {
                Thread.sleep(1000 + random.nextInt(2000)); // Время приготовления блюда варьируется
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

