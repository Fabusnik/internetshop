package ru.fab.repository.mock;

import ru.fab.model.Role;
import ru.fab.model.User;
import ru.fab.repository.UserRepository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new User("Admin", "admin", Role.ROLE_ADMIN, Role.ROLE_USER));
        save(new User("User", "user", Role.ROLE_USER));
    }

    @Override
    public User save(User user) {
        if (user.isNew()){
            user.setId(counter.incrementAndGet());
        }
        return repository.put(user.getId(), user);
    }

    @Override
    public boolean delete(Integer id) {
        repository.remove(id);
        return true;
    }

    @Override
    public User get(Integer id) {
        return repository.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return repository.values();
    }
}
