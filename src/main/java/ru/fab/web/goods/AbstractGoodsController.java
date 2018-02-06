package ru.fab.web.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fab.AuthorizedUser;
import ru.fab.model.Goods;
import ru.fab.model.Purchase;
import ru.fab.service.goods.GoodsService;
import ru.fab.service.purchases.PurchaseService;
import ru.fab.service.users.UserService;

import java.time.LocalDateTime;
import java.util.List;

public abstract class AbstractGoodsController {
    protected static final Logger log = LoggerFactory.getLogger(AbstractGoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private UserService userService;

    public List<Goods> getAll(){
        log.info("getAll");
        return goodsService.getAll();
    }

    public Goods get(Integer id){
        log.info("get {}", id);
        return goodsService.get(id);
    }

    public void delete(Integer id){
        log.info("delete {}", id);
        goodsService.delete(id);
    }

    public Goods create(Goods goods){
        log.info("create {}",goods);
        return goodsService.save(goods);
    }

    public void update(Goods goods){
        log.info("update {}", goods);
        goodsService.save(goods);
    }

    public void buy(String amount, Integer goodsId) {
        log.info("create Purchase idGoods {} stock {}",goodsId, amount);

        Goods goods = goodsService.get(goodsId);
        goods.setStock(goods.getStock()-Integer.valueOf(amount));

        goodsService.save(goods);

        purchaseService.save(new Purchase(
                userService.get(AuthorizedUser.id()),
                goodsService.get(goodsId),
                LocalDateTime.now(),
                (goodsService.get(goodsId).getPrice()*Integer.valueOf(amount)), Integer.valueOf(amount)));
    }
}
