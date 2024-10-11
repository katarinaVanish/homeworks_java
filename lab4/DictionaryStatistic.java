package org.knit.lab4;

import java.util.Random;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.dictionarySize = words.length;
        this.frequency = new int[alphabet.length];
        calculateStatistics();
    }

    private void calculateStatistics() {
        maxWordLength = 0;
        minWordLength = Integer.MAX_VALUE;
        polindrom = 0;

        for (String word : words) {
            int wordLength = word.length();
            if (wordLength > maxWordLength) {
                maxWordLength = wordLength;
            }
            if (wordLength < minWordLength) {
                minWordLength = wordLength;
            }
            if (isPalindrome(word)) {
                polindrom++;
            }
            countLetterFrequency(word);
        }
    }

    private boolean isPalindrome(String word) {
        String cleanWord = word.toLowerCase();
        int len = cleanWord.length();
        for (int i = 0; i < len / 2; i++) {
            if (cleanWord.charAt(i) != cleanWord.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public void printSymbolsStat() {
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " - " + frequency[i]);
        }
    }

    private void countLetterFrequency(String word) {
        word = word.toLowerCase();
        for (char c : word.toCharArray()) {
            for (int i = 0; i < alphabet.length; i++) {
                if (c == alphabet[i]) {
                    frequency[i]++;
                }
            }
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(dictionarySize);
        return words[randomIndex];
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public int getPolindromCount() {
        return polindrom;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

}
