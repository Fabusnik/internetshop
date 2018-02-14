package ru.fab.service.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.fab.model.Goods;
import ru.fab.model.Purchase;
import ru.fab.repository.GoodsRepository;
import ru.fab.repository.PurchaseRepository;
import ru.fab.repository.UserRepository;
import ru.fab.util.exception.NotEnoughException;
import ru.fab.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import static ru.fab.util.ValidationUtil.checkNotFoundWithId;

@Service
public class GoodsServiceImpl implements GoodsService {

    private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);


    private final GoodsRepository goodsRepository;

    private final PurchaseRepository purchaseRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository repository, PurchaseRepository purchaseRepository, UserRepository userRepository) {
        this.goodsRepository = repository;
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Goods get(int id) throws NotFoundException {
        return checkNotFoundWithId(goodsRepository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException{
       checkNotFoundWithId(goodsRepository.delete(id),id);
    }

    @Override
    public Goods save(Goods goods) {
        Assert.notNull(goods, "goods must not be null");
        return goodsRepository.save(goods);
    }

    @Override
    public List<Goods> getAll() {
        return goodsRepository.getAll();
    }

    @Override
    public void buy(Integer amount, Integer goodsId, int id) {
        Goods goods = checkNotFoundWithId(goodsRepository.get(goodsId), goodsId);
        if (goods.getStock() - amount >= 0) {
            log.info("create Purchase idGoods {} stock {}", goodsId, amount);
            goods.setStock(goods.getStock() - amount);
            goodsRepository.save(goods);
            purchaseRepository.save(new Purchase(
                    userRepository.get(id),
                    goodsRepository.get(goodsId),
                    LocalDateTime.now(),
                    (goodsRepository.get(goodsId).getPrice() * amount),
                    amount));
        } else
        {
            log.info("not enough goods in stock");
            throw new NotEnoughException("not enough goods in stock");
        }
    }

}
