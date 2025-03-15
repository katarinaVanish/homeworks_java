package org.knit.sem2.lab2_2.Task2_9;

@TaskDescription(9, "Конвейер сборки деталей");
/*
На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:
1. Штамповщик – вырезает заготовку (создает объект детали).
2. Сборщик – собирает из заготовки готовую деталь.
3. Оператор контроля качества – проверяет деталь и отправляет на склад.
Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.
*/

public class Task2_9 {
    public static void main(String[] args) {
        Factory factory = new Factory();

        new Thread(() -> {
            try {
                factory.stamp();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                factory.assemble();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                factory.qualityCheck();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
