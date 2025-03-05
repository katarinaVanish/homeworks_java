package org.knit.sem2.lab2_2.Task2_7;

import java.util.Random;

class Producer extends Thread {
    private final Warehouse warehouse;
    private final Random random = new Random();

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        int itemNumber = 1;
        while (true) {
            warehouse.produce("Товар " + itemNumber++);
            try {
                Thread.sleep(500 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
