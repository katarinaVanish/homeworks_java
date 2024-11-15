package org.knit.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task10 {
    public static void main(String[] args){
        List<String> words = getWords("misc/dictionary.txt");
        if (words.isEmpty()) {
            System.out.println("Словарь пуст или не найден.");
            return;
        }
        int count = 0;
        System.out.println("Добро пожаловать в игру 'Виселица'!\n" +
                "По умолчанию вам предлагается угадать букву.\n" +
                "Вы также можете угадать слово, введя его целиком.\n" +
                "Если хотите закончить игру, введите 'ВЫХОД'\n");
        Scanner scanner = new Scanner(System.in);
        Iterator<String> iteratorW = words.iterator();
        while (true){
            String word = iteratorW.next();
            int result = startGame(word);
            if (result == -1){
                break;
            } else if (result == 1) {
                count += 1;
                System.out.println("\nПоздравляем!");
            } else {
                System.out.println("\nК сожалению вы не угадали.");
            }
            System.out.printf("Количество угаданных слов: %d%n" +
                    "Если хотите продолжить игру, нажмите Enter; если хотите закончить игру, введите 'ВЫХОД'%n", count);
            String userInput = scanner.nextLine().trim();
            if (userInput.equals("ВЫХОД")){
                break;
            }
        }

    }

    public static int startGame(String word){
        Scanner scanner = new Scanner(System.in);
        List<Character> actualWord = new ArrayList<>();
        Set<Character> letters = new HashSet<>();
        int actualAttempts = 6;

        char[] wordArray = word.toCharArray();
        for (Character w : wordArray){
            letters.add(w);
            actualWord.add('_');
        }

        while (actualAttempts > 0 && actualWord.contains('_')){
            System.out.print("Загаданное слово: ");
            for(Character letter : actualWord){
                System.out.print(letter);
            }

            System.out.print("\nВвод: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.length() > 1){
                if (userInput.equals(word)) {
                    return 1;
                } else if (userInput.equals("ВЫХОД")) {
                    return -1;
                }
                actualAttempts -=1;
                System.out.printf("Ответ неверный! Осталось попыток: %d%n", actualAttempts);
            } else {
                char userLetter  = userInput.charAt(0);

                if (letters.contains(userLetter)) {
                    for (int i = 0; i < word.length(); i++){
                        if (wordArray[i] == userLetter){
                            actualWord.set(i, userLetter);
                        }
                    }
                } else {
                    actualAttempts -= 1;
                    System.out.printf("Такой буквы в слове нет! Остаось попыток: %d%n", actualAttempts);
                }
            }

        }
        System.out.printf("Ответ: %s", word);
        if (actualWord.contains('_')){
            return 0;
        }
        return 1;
    }

    public static List<String> getWords(String path) {
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (word.length() > 3){
                    words.add(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден: " + e.getMessage());
        }
        Collections.shuffle(words);
        return words;
    }
}
