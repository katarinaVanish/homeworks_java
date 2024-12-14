package org.knit.lab11;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) throws SQLException {
        if (userDAO.emailExists(email)) {
            throw new IllegalArgumentException("Такая почта уже существует.");
        }
        userDAO.create(new User(0, name, email));
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) == null) {
            throw new IllegalArgumentException("Пользователь не найден.");
        }
        userDAO.delete(id);
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        if (userDAO.findById(id) == null) {
            throw new IllegalArgumentException("Пользователь не найден.");
        }
        if (userDAO.emailExists(newEmail)) {
            throw new IllegalArgumentException("Такая почта уже существует.");
        }
        userDAO.update(new User(id, newName, newEmail));
    }
}
