package ru.fab.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fab.model.User;
import ru.fab.service.users.UserService;

import java.util.List;

public abstract class AbstractUserController {
    protected static final Logger log = LoggerFactory.getLogger(AbstractUserController.class);

    @Autowired
    private UserService service;

    public User get(Integer id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public List<User> getAll(){
        log.info("getAll users");
        return service.getAll();
    }

    public User create(User user) {
        log.info("create {}", user);
        return service.create(user);
    }

    public void update(User user) {
        log.info("update {}", user);
        service.update(user);
    }

    public void delete(Integer id){
        log.info("deleted {}",id);
        service.delete(id);
    }
}
