package org.knit.lab7;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Task12 {
    private static long totalWordCount = 0;

    public static void main(String[] args) {
        Path startPath = Paths.get("misc/folder1"); // начальная директория для обхода

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor());
            System.out.println("Общее количество слов во всех текстовых файлах: " + totalWordCount);
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }
    }

    // Реализация FileVisitor для обхода файловой системы
    private static class SimpleFileVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (file.toString().endsWith(".txt")){
                try{
                    long wordCount = countWords(file);
                    totalWordCount += wordCount;
                } catch (IOException e) {
                    System.out.println("Ошибка при подсчёте строк или слов в файле: " + file);
                }
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Ошибка доступа к файлу: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            return FileVisitResult.CONTINUE;
        }
    }

    // Метод для подсчета слов в файле
    private static long countWords(Path filePath) throws IOException {
        long wordCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова, используя пробелы и другие разделители
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }

}
