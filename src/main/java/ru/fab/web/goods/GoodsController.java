package ru.fab.web.goods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.fab.AuthorizedUser;
import ru.fab.model.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController extends AbstractGoodsController {


    @PostMapping("/buy")
    public String buy(@RequestParam("amount") Integer amount,
                      @RequestParam("goodsId") Integer goodsId) {
        super.buy(amount, goodsId, AuthorizedUser.id());
        return "redirect:/goods";
    }


    @PostMapping
    public String updateOrCreate(@Valid Goods goods, BindingResult result) {
        if (result.hasErrors()){
            return "goodsEdit";
        }

        if (goods.getId() == null) {
            super.create(goods);
        } else {
            super.update(goods);
        }
        return "redirect:/goods";
    }


    @GetMapping("/admin/delete")
    public String delete(@RequestParam("id") int id) {
        super.delete(id);
        return "redirect:/goods";
    }

    @GetMapping("/admin/create")
    public String create(Model model) {
        model.addAttribute("goods", new Goods("", "", 0, 0));
        return "goodsEdit";
    }

    @GetMapping("/admin/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("goods", super.get(id));
        return "goodsEdit";
    }
}
