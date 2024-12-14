package org.knit.lab11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            UserService userService = new UserService(new UserDAOImpl());

            while (true) {
                System.out.println("Введите команду:");
                String[] input = scanner.nextLine().split(" ");
                String command = input[0];

                try {
                    switch (command) {
                        case "add":
                            userService.registerUser(input[1], input[2]);
                            System.out.println("User added successfully.");
                            break;
                        case "list":
                            userService.listAllUsers().forEach(user ->
                                    System.out.println(user.getId() + ": " + user.getName() + " - " + user.getEmail()));
                            break;
                        case "delete":
                            userService.deleteUser(Integer.parseInt(input[1]));
                            System.out.println("User deleted successfully.");
                            break;
                        case "update":
                            userService.updateUser(Integer.parseInt(input[1]), input[2], input[3]);
                            System.out.println("User updated successfully.");
                            break;
                        case "exit":
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Unknown command.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
