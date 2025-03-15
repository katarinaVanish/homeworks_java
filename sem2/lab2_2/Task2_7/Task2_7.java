package org.knit.sem2.lab2_2.Task2_7;

@TaskDescription(7, "Производитель-Потребитель с ограничением");
/*
Описание:
- Производитель создает товары (максимум 5).
- Потребитель забирает товары.
- Если товаров нет, потребитель ждет (wait()).
- Если товаров максимум, производитель ждет (wait()).
*/

public class Task2_7 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        new Producer(warehouse).start();
        new Consumer(warehouse).start();
    }
}
