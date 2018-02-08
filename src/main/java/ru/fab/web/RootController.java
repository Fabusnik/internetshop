package ru.fab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fab.model.Role;
import ru.fab.model.User;
import ru.fab.service.goods.GoodsService;
import ru.fab.service.users.UserService;
import ru.fab.util.UserUtil;
import ru.fab.web.user.AbstractUserController;

import javax.validation.Valid;

@Controller
public class RootController extends AbstractUserController{

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:goods";
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("register", true);
        return "userEdit";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "userEdit";
        } else {
            super.create(UserUtil.createUser(user));
            return "redirect:login?registered&username=" + user.getName();
        }
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @GetMapping("/goods")
    public String goodsList(Model model){
        model.addAttribute("goodsList", goodsService.getAll());
        return "goods";
    }

    @GetMapping("/users")
    public String userList(Model model){
        model.addAttribute("userList", userService.getAll());
        return "users";
    }
}
