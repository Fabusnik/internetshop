package ru.fab.service;

import ru.fab.model.User;
import ru.fab.util.exception.NotFoundException;

public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    void update(User user);
}
