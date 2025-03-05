package org.knit.sem2.lab2_2.Task2_4;

import java.util.LinkedList;
import java.util.Queue;

class GasStation {
    private final int capacity = 2;
    private int availablePumps = capacity;
    private final Queue<Car> queue = new LinkedList<>();

    public synchronized void refuel(Car car) {
        queue.add(car);
        while (!canRefuel(car)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.remove(car);
        availablePumps--;
        System.out.println(car.getName() + " начал заправку.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (this) {
            availablePumps++;
            System.out.println(car.getName() + " завершил заправку.");
            notifyAll();
        }
    }

    private boolean canRefuel(Car car) {
        return availablePumps > 0 && queue.peek() == car;
    }
}
