package ru.fab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.fab.service.goods.GoodsService;
import ru.fab.service.users.UserService;

@Controller
public class RootController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:goods";
    }

//    @PostMapping("/users/login")
//    public String setUser(HttpServletRequest request){
//        String userId = request.getParameter("userId");
//        AuthorizedUser.setId(Integer.valueOf(userId));
//        return "redirect:/goods";
//    }

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
