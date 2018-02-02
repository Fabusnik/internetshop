package ru.fab.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fab.model.User;
import ru.fab.repository.UserRepository;
import ru.fab.service.users.UserService;
import ru.fab.util.exception.NotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
