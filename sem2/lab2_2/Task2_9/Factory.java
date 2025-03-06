package org.knit.sem2.lab2_2.Task2_9;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Factory {
    private final BlockingQueue<String> rawMaterials = new LinkedBlockingQueue<>(5);
    private final BlockingQueue<String> assembledParts = new LinkedBlockingQueue<>(5);

    public void stamp() throws InterruptedException {
        int count = 1;
        while (true) {
            String part = "Заготовка " + count;
            rawMaterials.put(part);
            System.out.println("Штамповщик: " + part + " создана");
            count++;
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void assemble() throws InterruptedException {
        while (true) {
            String part = rawMaterials.take();
            String assembledPart = part.replace("Заготовка", "Деталь");
            assembledParts.put(assembledPart);
            System.out.println("Сборщик: " + part + " обработана");
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void qualityCheck() throws InterruptedException {
        while (true) {
            String part = assembledParts.take();
            System.out.println("Оператор контроля: " + part + " проверена и отправлена на склад");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
