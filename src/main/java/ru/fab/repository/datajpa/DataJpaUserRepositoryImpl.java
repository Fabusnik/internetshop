package ru.fab.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.model.User;
import ru.fab.repository.UserRepository;

import java.util.List;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {

    @Autowired
    private CrudUserRepository repository;

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.delete(id) != 0;
    }

    @Override
    public User get(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public User getByName(String name) {
        return repository.findByName(name);
    }
}
