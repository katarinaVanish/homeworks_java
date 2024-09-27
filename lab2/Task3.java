package org.knit.lab2;

import java.util.Scanner;

public class Task3 {
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String input;
        while (true){
            System.out.print("Введите первое число: ");
            input = scanner.next();
            if (input.equalsIgnoreCase("exit")){
                System.out.println("Выход из программы.");
                break;
            }
            double num1 = Double.parseDouble(input);
            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.next();
            System.out.print("Введите второе число: ");
            double num2 = Double.parseDouble(scanner.next());
            try{
                double result;
                switch (operator){
                    case "+":
                        result = calculator.add(num1, num2);
                        break;
                    case "-":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "/":
                        result = calculator.divide(num1, num2);
                        break;
                    default:
                        System.out.println("Ошибка: некорректный оператор.");
                        continue;
                }
                System.out.println("Результат: " + result);
            } catch (ArithmeticException e){
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();

    }

}
