package org.knit.sem2.lab2_2.Task2_7;

public class Task2_7 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        new Producer(warehouse).start();
        new Consumer(warehouse).start();
    }
}
