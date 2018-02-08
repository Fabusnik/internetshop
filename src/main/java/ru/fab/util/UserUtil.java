package ru.fab.util;


import ru.fab.model.Role;
import ru.fab.model.User;

import javax.validation.Valid;

public class UserUtil {
    public static User createUser(User user) {
        return new User(user.getName(), user.getPassword(), Role.ROLE_USER);
    }
}
