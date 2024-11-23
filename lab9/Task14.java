package org.knit.lab9;

import java.util.Scanner;

public class Task14 {
    enum TrafficLight{
        RED("зеленый"),
        GREEN("желтый"),
        YELLOW("красный");

        private final String nextLight;

        TrafficLight(String light){
            nextLight = light;
        }

        public TrafficLight getNext(){
            return TrafficLight.valueOf(nextLight);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String light = scanner.nextLine();
        TrafficLight trafficLight = TrafficLight.valueOf(light);
        System.out.println("Следующий сигнал: " + trafficLight.getNext());

        scanner.close();

    }
}
