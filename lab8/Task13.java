package org.knit.lab8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task13 {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        try{
            users = UserManager.loadUsers();
            System.out.println("Данные загружены из файла.");
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Не удалось загрузить данные. Начало с пустого списка.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("\nМеню:");
        System.out.println("1. Добавить нового пользователя");
        System.out.println("2. Показать всех пользователей");
        System.out.println("3. Сохранить список пользователей в файл");
        System.out.println("4. Загрузить список пользователей из файла");
        System.out.println("5. Выйти");

        while (running){
            System.out.println("Выберите номер действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    showUser();
                    break;
                case 3:
                    saveUsersToFile();
                    break;
                case 4:
                    loadUsersFromFile();
                    break;
                case 5:
                    saveUsersToFile();
                    running = false;
                    break;
                default:
                    System.out.println("Неверный ввод. Повторите попытку.");
            }
        }
        scanner.close();
    }
    private static void addUser(Scanner scanner){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите email: ");
        String email = scanner.nextLine();

        users.add(new User(name, age, email));
        System.out.println("Пользователь добавлен.");
    }

    private static void showUser(){
        if (!users.isEmpty()){
            System.out.println("Список пользователей:");
            for (User user : users){
                System.out.println(user);
            }
        }
        else System.out.println("Список пользователей пуст.");
    }

    private static void saveUsersToFile(){
        try{
            UserManager.saveUsers(users);
            System.out.println("Список пользователей сохранен в файл.");

        } catch (IOException e){
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    private static void loadUsersFromFile(){
        try {
            users = UserManager.loadUsers();
            System.out.println("Список пользователей загружен из файла.");

        } catch (IOException | ClassNotFoundException e){
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }
}
