package org.knit.lab9;

public class User {
    @NotNull(message = "Поле name не должно быть null.")
    private String name;

    @MaxLength(value = 10, message = "Поле username превышает максимальную длину 10.")
    private String username;

    @Min(value = 18, message = "Поле age должно быть не меньше 18.")
    private int age;

    // Конструкторы, геттеры и сеттеры
    public User(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}
