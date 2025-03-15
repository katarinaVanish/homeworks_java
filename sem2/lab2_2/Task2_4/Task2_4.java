package org.knit.sem2.lab2_2.Task2_4;

@TaskDescription(4, "Автозаправочная станция");
/*
На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.
*/

public class Task2_4 {
    public static void main(String[] args) {
        GasStation station = new GasStation();
        for (int i = 1; i <= 5; i++) { 
            new Car("Машина " + i, station).start();
        }
    }

}
