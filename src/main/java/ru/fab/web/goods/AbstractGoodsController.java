package ru.fab.web.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fab.model.Goods;
import ru.fab.service.goods.GoodsService;
import ru.fab.util.GoodsUtil;

import java.util.List;

public abstract class AbstractGoodsController {
    protected static final Logger log = LoggerFactory.getLogger(AbstractGoodsController.class);

    @Autowired
    private GoodsService goodsService;


    public List<Goods> getAll() {
        log.info("getAll");
        return goodsService.getAll();
    }

    public Goods get(Integer id) {
        log.info("get goods by {}",  id);
        return goodsService.get(id);
    }

    public void delete(Integer id) {
        log.info("delete goods {} by {}", id, goodsService.get(id));
        goodsService.delete(id);
    }

    public Goods create(Goods goods) {
        log.info("create {}", goods);
        return goodsService.save(goods);
    }

    public void update(Goods goods) {
        log.info("update {}", goods);
        goodsService.save(goods);
    }

    public void buy(Integer amount, Integer goodsId, int id) {
        goodsService.buy(amount, goodsId, id);
    }
}
