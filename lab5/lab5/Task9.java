package org.knit.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        List<String> words = getWords("misc/dictionary.txt");
        if (words.isEmpty()) {
            System.out.println("Словарь пуст или не найден.");
            return;
        }
        startGame(words);
    }
    
    public static void startGame(List<String> words) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int correctWords = 0; // Счетчик правильных слов
        int totalWords = 0;   // Общее количество предложенных слов
        int totalChars = 0;   // Общее количество введенных символов

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60 * 1000;

        System.out.println("Игра началась! Введите предложенные слова за одну минуту:");

        while (System.currentTimeMillis() < endTime) {
            String randomWord = words.get(random.nextInt(words.size()));
            System.out.println("Введите слово " + randomWord);

            String userInput = scanner.nextLine();

            // Проверка, что время не вышло
            if (System.currentTimeMillis() >= endTime) {
                System.out.println("Время истекло!");
                break;
            }
            
            if (userInput.equals(randomWord)) {
                correctWords++;
            }
            totalWords++;
            totalChars += userInput.length();
        }
        scanner.close();
        double speed = totalChars / (double)60; // Скорость символов в секунду
        
        System.out.println("Игра окончена!");
        System.out.println("Количество предложенных слов: " + totalWords);
        System.out.println("Количество правильных слов: " + correctWords);
        System.out.println("Количество введенных символов: " + totalChars);
        System.out.printf("Скорость ввода: %.2f символов в секунду\n", speed);
    }

    public static List<String> getWords(String path) {
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден: " + e.getMessage());
        }
        return words;
    }
}
