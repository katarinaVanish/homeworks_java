package org.knit.lab10;

public class Task23 {
    public static <T> void printType(T object) {
        System.out.println(object.getClass().getName());
    }

    public static void main(String[] args) {
        printType(123); // java.lang.Integer
        printType("Hello"); // java.lang.String
    }
}
