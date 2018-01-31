package ru.fab.repository.jdbc;

import org.springframework.stereotype.Repository;
import ru.fab.model.User;
import ru.fab.repository.UserRepository;

import java.util.Collection;

@Repository
public class JdbcUserRepository implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }
}
