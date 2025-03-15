package org.knit.sem2.lab2_2.Task2_5;

import java.util.Random;

@TaskDescription(5, "Ресторан: Повар и Официант");
/*
В ресторане работает один повар и один официант.
- Повар готовит блюда и ставит их на поднос (максимум 3 блюда).
- Официант берет готовые блюда и подает их клиентам.
*/

public class Task2_5 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Chef chef = new Chef(restaurant);
        Waiter waiter = new Waiter(restaurant);
        Random random = new Random();

        chef.start();
        waiter.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500 + random.nextInt(2000)); // Задержка между заказами
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Новый заказ поступил в ресторан!");
            restaurant.placeOrder();
        }
    }
}
