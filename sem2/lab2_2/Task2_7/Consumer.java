package org.knit.sem2.lab2_2.Task2_7;

import java.util.Random;

class Consumer extends Thread {
    private final Warehouse warehouse;
    private final Random random = new Random();

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            warehouse.consume();
            try {
                Thread.sleep(2000 + random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
