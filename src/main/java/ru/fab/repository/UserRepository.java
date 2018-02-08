package ru.fab.repository;


import ru.fab.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    //false if bot found
    boolean delete(Integer id);

    //null if not found
    User get(Integer id);

    List getAll();

    User getByName(String name);

}
