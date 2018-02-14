package ru.fab.service.goods;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.GoodsTestData;
import ru.fab.model.Goods;
import ru.fab.service.purchases.PurchaseService;
import ru.fab.util.exception.NotEnoughException;
import ru.fab.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static ru.fab.GoodsTestData.*;
import static ru.fab.util.ValidationUtil.checkNotFoundWithId;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@ActiveProfiles("hsqldb")
@Transactional
public class GoodsServiceImplTest {

    @Autowired
    private GoodsService service;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void get() throws Exception {
        Goods toy = service.get(1);
        assertMatch(toy,GOODS_TOY);
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
        assertMatch(service.getAll(), GOODS_CAT, GOODS_ROSE, GOODS_WATER);
    }

    @Test
    public void deleteNotFound() throws Exception{
        thrown.expect(NotFoundException.class);
        service.delete(31);
    }

    @Test
    public void save() throws Exception {
        Goods createdGoods = new Goods("newGoods", "new description", 10,10);
        service.save(createdGoods);
        List<Goods> goodsList = service.getAll();
        assertMatch(goodsList, GOODS_CAT, GOODS_ROSE, GOODS_TOY, GOODS_WATER,  createdGoods);
    }

    @Test
    public void getAll() throws Exception {
        List<Goods> goodsList = service.getAll();
        assertMatch(goodsList, GOODS_CAT, GOODS_ROSE, GOODS_TOY, GOODS_WATER);
    }

    @Test
    public void buy() throws Exception {
        Goods goods = checkNotFoundWithId(service.get(GOOD_TOY_ID), GOOD_TOY_ID);

        service.buy(1,1, 2);
        goods.setStock(goods.getStock()-1);
        assertMatch(service.get(GOOD_TOY_ID), goods);
    }

    @Test
    public void buyWithNotEnough() throws Exception {
        thrown.expect(NotEnoughException.class);
        service.buy(6,1, 2);
    }


//    Goods goods = checkNotFoundWithId(goodsRepository.get(goodsId), goodsId);
//        if (goods.getStock() - amount >= 0) {
//        log.info("create Purchase idGoods {} stock {}", goodsId, amount);
//        goods.setStock(goods.getStock() - amount);
//        goodsRepository.save(goods);
//        purchaseRepository.save(new Purchase(
//                userRepository.get(AuthorizedUser.id()),
//                goodsRepository.get(goodsId),
//                LocalDateTime.now(),
//                (goodsRepository.get(goodsId).getPrice() * amount),
//                amount));
//    } else
//    {
//        log.info("not enough goods in stock");
//        throw new NotEnoughException("not enough goods in stock");
//    }

}