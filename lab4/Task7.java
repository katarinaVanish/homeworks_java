package org.knit.lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task7 {
    public void execute() {
        try {
            Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine()).append(" ");
            }
            scanner.close();

            String[] words = sb.toString().split("\\s+"); // все спец символы и пробелы
            StringBuilder string = new StringBuilder();
            for (char i='а'; i <= 'я'; i++){
                string.append(i);
            }
            char[] alphabet = string.toString().toCharArray();

            DictionaryStatistic stats = new DictionaryStatistic(words, alphabet);
            System.out.print("Количество слов в словаре: ");
            System.out.print(stats.getDictionarySize());
            System.out.print("Количество палиндромов: ");
            System.out.print(stats.getPolindromCount());
            System.out.print("Максимальная длина слова: ");
            System.out.print(stats.getMaxWordLength());
            System.out.print("Минимальная длина слова: ");
            System.out.print(stats.getMinWordLength());
            System.out.print("Случайное слово: ");
            System.out.print(stats.getRandomWord());
            System.out.println("\nЧастота букв в словаре:");
            stats.printSymbolsStat();

        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден: " + e.getMessage());
        }
    }
}
