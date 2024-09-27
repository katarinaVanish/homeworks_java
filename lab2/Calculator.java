package org.knit.lab2;

public class Calculator {
    public Double add(double a, double b){
        return a + b;
    }
    public Double subtract(double a, double b){
        return a - b;
    }
    public Double multiply(double a, double b){
        return a * b;
    }
    public Double divide(double a, double b) throws ArithmeticException{
        if (b == 0){
            throw new ArithmeticException("Деление на 0 невозможно");
        } else {
            return a / b;
        }

    }
}
