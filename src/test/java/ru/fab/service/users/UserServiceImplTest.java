package ru.fab.service.users;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.UserTestData;
import ru.fab.model.Role;
import ru.fab.model.User;
import ru.fab.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static ru.fab.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@ActiveProfiles("hsqldb")
@Transactional
public class UserServiceImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private UserService service;

    @Test
    public void create() throws Exception {
        User createdUser = new User("newUser", "password", Role.ROLE_USER);
        service.create(createdUser);
        List<User> userList = service.getAll();
        UserTestData.assertMatch(userList, ADMIN, USER, createdUser);
    }

    @Test(expected = DataAccessException.class)
    public void duplicateUserCreate() throws Exception{
        service.create(new User("User", "password", Role.ROLE_USER));
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
        UserTestData.assertMatch(service.getAll(), USER);
    }

    @Test
    public void deleteNotFound() throws Exception{
        thrown.expect(NotFoundException.class);
        service.delete(3);
    }

    @Test
    public void get() throws Exception {
        User admin = service.get(ADMIN_ID);
        assertMatch(admin, ADMIN);
    }

    @Test
    public void update() throws Exception {
        User updatedUser = new User(1,"newAdmin", "admin", Role.ROLE_ADMIN);
        service.update(updatedUser);
        User expectedUser = service.get(1);
        assertMatch(updatedUser, expectedUser);
    }

    @Test
    public void getAll() throws Exception {
        List<User> userList = service.getAll();
        UserTestData.assertMatch(userList, ADMIN, USER);
    }


}