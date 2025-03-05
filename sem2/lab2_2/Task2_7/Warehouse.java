package org.knit.sem2.lab2_2.Task2_7;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private final int capacity = 5;
    private final Queue<String> storage = new LinkedList<>();

    public synchronized void produce(String item) {
        while (storage.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        storage.add(item);
        System.out.println("Производитель создал: " + item);
        notifyAll();
    }

    public synchronized void consume() {
        while (storage.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String item = storage.poll();
        System.out.println("Потребитель забрал: " + item);
        notifyAll();
    }
}
