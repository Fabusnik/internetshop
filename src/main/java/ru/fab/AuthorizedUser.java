package ru.fab;

import ru.fab.model.AbstractEntity;

public class AuthorizedUser {
    private static int id = AbstractEntity.LOGGED_USER_ID;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

}
