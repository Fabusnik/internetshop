package ru.fab.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fab.model.User;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserRestController extends AbstractUserController {

    @GetMapping
    public List<User> getAll(){
        return super.getAll();
    }


}
