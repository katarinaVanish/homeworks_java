package org.knit.lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class Task7 {
    public void execute() {
        try {
            Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
            StringJoiner sb = new StringJoiner(";");
            while (scanner.hasNext()) {
                sb.add(scanner.nextLine());
            }
            scanner.close();

            String[] words = sb.toString().split(";"); // все спец символы и пробелы
            StringBuilder string = new StringBuilder();
            for (char i='а'; i <= 'я'; i++){
                string.append(i);
            }
            char[] alphabet = string.toString().toCharArray();

            DictionaryStatistic stats = new DictionaryStatistic(words, alphabet);
            System.out.print("Количество слов в словаре: ");
            System.out.println(stats.getDictionarySize());
            System.out.print("Количество палиндромов: ");
            System.out.println(stats.getPolindromCount());
            System.out.print("Максимальная длина слова: ");
            System.out.println(stats.getMaxWordLength());
            System.out.print("Минимальная длина слова: ");
            System.out.println(stats.getMinWordLength());
            System.out.print("Случайное слово: ");
            System.out.println(stats.getRandomWord());
            System.out.println("\nЧастота букв в словаре:");
            stats.printSymbolsStat();

        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден: " + e.getMessage());
        }
    }
}
