package ru.fab.service.users;

import ru.fab.model.User;
import ru.fab.util.exception.NotFoundException;

import java.util.List;


public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    void update(User user);

    List getAll();
}
