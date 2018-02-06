package ru.fab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fab.AuthorizedUser;
import ru.fab.service.goods.GoodsService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @Autowired
    private GoodsService service;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request){
        String userId = request.getParameter("userId");
        AuthorizedUser.setId(Integer.valueOf(userId));
        return "redirect:/goods";
    }

    @GetMapping("/goods")
    public String goodsList(Model model){
        model.addAttribute("goodsList", service.getAll());
        return "goods";
    }
}
