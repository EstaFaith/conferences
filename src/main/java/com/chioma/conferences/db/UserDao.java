package com.chioma.conferences.db;

import com.chioma.conferences.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final List<User> store = new ArrayList<>();

    public User getById(int id) {

        User result = new User();
        result.setUserId(-1);

        for (User user : store) {
            if (user.getUserId() == id) {
                result = user;
            }
        }

        return result;
    }

    public User getUserByLoginPassword(final String login, final String password) {

        User result = new User();
        result.setUserId(-1);

        for (User user : store) {
            if (user.getUserLogin().equals(login) && user.getUserPassword().equals(password)) {
                result = user;
            }
        }

        return result;
    }

    public boolean add(final User user) {

        for (User u : store) {
            if (u.getUserLogin().equals(user.getUserLogin()) && u.getUserPassword().equals(user.getUserPassword())) {
                return false;
            }
        }

        return store.add(user);
    }

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE result = User.ROLE.UNKNOWN;

        for (User user : store) {
            if (user.getUserLogin().equals(login) && user.getUserPassword().equals(password)) {
                result = user.getRole();
            }
        }

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (User user : store) {
            if (user.getUserLogin().equals(login) && user.getUserPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
