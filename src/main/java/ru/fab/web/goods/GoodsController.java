package ru.fab.web.goods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fab.model.Goods;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController extends AbstractGoodsController{


    @PostMapping("/buy")
    public String buy(HttpServletRequest request){
        Integer amount = Integer.valueOf(request.getParameter("amount"));
        Integer goodsId = Integer.valueOf(request.getParameter("goodsId"));
        super.buy(amount, goodsId);
        return "redirect:/goods";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        Goods goods = new Goods(request.getParameter("name"),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("price")),
                Integer.valueOf(request.getParameter("stock")));


        if (request.getParameter("id").isEmpty()) {
            super.create(goods);
        } else {
            goods.setId(getId(request));
            super.update(goods);
        }
        return "redirect:/goods";
    }


    @GetMapping("/admin/delete")
    public String delete(HttpServletRequest request){
        super.delete(getId(request));
        return "redirect:/goods";
    }

    @GetMapping("/admin/create")
    public String create(Model model) {
        model.addAttribute("goods", new Goods("", "", 0, 0));
        return "goodsEdit";
    }

    @GetMapping("/admin/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("goods", super.get(getId(request)));
        return "goodsEdit";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }






}
