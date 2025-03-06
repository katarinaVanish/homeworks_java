package org.knit.sem2.lab2_2.Task2_9;

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
