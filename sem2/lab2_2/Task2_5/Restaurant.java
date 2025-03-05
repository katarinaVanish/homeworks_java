package org.knit.sem2.lab2_2.Task2_5;

import java.util.LinkedList;
import java.util.Queue;


class Restaurant {
    private final int capacity = 3;
    private final Queue<String> tray = new LinkedList<>();
    private int pendingOrders = 0;

    public synchronized void placeOrder() {
        pendingOrders++;
        notifyAll();
    }

    public synchronized void cook(String dish) {
        while (tray.size() >= capacity || pendingOrders == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        pendingOrders--;
        tray.add(dish);
        System.out.println("Повар приготовил: " + dish);
        notifyAll();
    }

    public synchronized void serve() {
        while (tray.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String dish = tray.poll();
        System.out.println("Официант подал: " + dish);
        notifyAll();
    }
}
