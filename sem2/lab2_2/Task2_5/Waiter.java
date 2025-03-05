package org.knit.sem2.lab2_2.Task2_5;

class Waiter extends Thread {
    private final Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (true) {
            restaurant.serve();
            try {
                Thread.sleep(3000); // Время подачи блюда
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}