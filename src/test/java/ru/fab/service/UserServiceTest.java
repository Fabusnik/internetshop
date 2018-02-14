package ru.fab.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.model.Role;
import ru.fab.model.User;
import ru.fab.service.users.UserService;

import java.util.List;

import static ru.fab.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@ActiveProfiles("hsqldb")
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void create() throws Exception {

    }

    @Test(expected = DataAccessException.class)
    public void duplicateUserCreate() throws Exception{
        service.create(new User("User", "password", Role.ROLE_USER));
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {
        User admin = service.get(ADMIN_ID);
        assertMatch(admin,ADMIN);
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void getAll() throws Exception {
        List<User> all = service.getAll();
        assertMatch(all, ADMIN, USER);
    }



}