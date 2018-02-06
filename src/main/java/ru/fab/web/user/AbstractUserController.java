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

    public List<User> getAll(){
        log.info("getAll users");
        return service.getAll();
    }
}
