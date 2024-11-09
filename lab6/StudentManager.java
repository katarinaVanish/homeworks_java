package org.knit.lab6;

import java.util.Scanner;
import java.util.TreeSet;

public class StudentManager {
    private final TreeSet<String> students;

    public StudentManager() {
        students = new TreeSet<>();
    }

    public void addStudent(String name) {
        if (students.contains(name)) {
            System.out.println("Ошибка: Студент с таким именем уже существует.");
        } else {
            students.add(name);
            System.out.println("Студент добавлен.");
        }
    }

    public void removeStudent(String name) {
        if (students.contains(name)) {
            students.remove(name);
            System.out.println("Студент удален.");
        } else {
            System.out.println("Ошибка: Студент с таким именем не найден.");
        }
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
        } else {
            System.out.println("Список студентов:");
            students.forEach(System.out::println);
        }
    }

    public void findStudent(String name) {
        if (students.contains(name)) {
            System.out.println("Студент найден.");
        } else {
            System.out.println("Студент не найден.");
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Найти студента");
            System.out.println("5. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка новой строки

            switch (choice) {
                case 1:
                    System.out.print("Введите имя студента: ");
                    String nameToAdd = scanner.nextLine();
                    manager.addStudent(nameToAdd);
                    break;
                case 2:
                    System.out.print("Введите имя студента для удаления: ");
                    String nameToRemove = scanner.nextLine();
                    manager.removeStudent(nameToRemove);
                    break;
                case 3:
                    manager.showAllStudents();
                    break;
                case 4:
                    System.out.print("Введите имя студента для поиска: ");
                    String nameToFind = scanner.nextLine();
                    manager.findStudent(nameToFind);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите вариант от 1 до 5.");
                    break;
            }
        }
        scanner.close();
    }
}
