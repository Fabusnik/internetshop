package ru.fab.web.goods;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fab.AuthorizedUser;
import ru.fab.model.Goods;
import ru.fab.service.goods.GoodsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/goods")
public class GoodsAdminRestController extends AbstractGoodsController{
    private static final Logger log = LoggerFactory.getLogger(GoodsAdminRestController.class);

    private final GoodsService service;

    @Autowired
    public GoodsAdminRestController(GoodsService service) {
        this.service = service;
    }


    @PostMapping("/buy")
    public String buy(HttpServletRequest request){
        String stock = request.getParameter("amount");
        Integer goodsId = Integer.valueOf(request.getParameter("goodsId"));
        super.buy(stock, goodsId);
        return "redirect:/goods";
    }


}
