package ru.fab.web.goods;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.fab.AuthorizedUser;
import ru.fab.model.Goods;
import ru.fab.service.goods.GoodsService;

import java.util.List;

@Controller
public class GoodsAdminRestController {
    private static final Logger log = LoggerFactory.getLogger(GoodsAdminRestController.class);

    private final GoodsService service;

    @Autowired
    public GoodsAdminRestController(GoodsService service) {
        this.service = service;
    }


    public List<Goods> getAll(){
        log.info("getAll for user {}", AuthorizedUser.id());
        return service.getAll();
    }

    public Goods get(Integer id){
        log.info("get goods for id {}", id);
        return service.get(id);
    }

    public void delete(Integer id){
        log.info("delete goods by id {}", id);
        service.delete(id);
    }

    public Goods save(Goods goods){
        log.info("save goods {}",goods);
        return service.save(goods);
    }

}
