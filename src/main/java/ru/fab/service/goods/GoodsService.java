package ru.fab.service.goods;

import ru.fab.model.Goods;
import ru.fab.util.exception.NotFoundException;

import java.util.List;


public interface GoodsService {
    Goods get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Goods save(Goods goods);

    List<Goods> getAll();

    void buy(Integer amount, Integer goodsId, int id);

}
