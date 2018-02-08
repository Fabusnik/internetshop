package ru.fab.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fab.model.Role;
import ru.fab.model.User;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/users")
public class UserController extends AbstractUserController {

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User("", "",  Role.ROLE_USER));
        return "userEdit";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("user", super.get(getId(request)));
        return "userEdit";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/users";
    }



    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        User user = new User(request.getParameter("name"),
                request.getParameter("password"),
                Role.ROLE_USER);


        if (request.getParameter("id").isEmpty()) {
            super.create(user);
        } else {
            user.setId(getId(request));
            super.update(user);
        }
        return "redirect:/users";
    }



    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }


}
