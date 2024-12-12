package org.knit.lab9;

public class Task17 {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User(null, "LongUsernameHere", 16);
        Validator.validate(user);
    }
}
