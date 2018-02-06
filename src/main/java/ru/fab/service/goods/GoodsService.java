package ru.fab.service.goods;

import ru.fab.model.Goods;
import ru.fab.util.exception.NotFoundException;

import java.util.List;


public interface GoodsService {
    Goods get(Integer id) throws NotFoundException;

    void delete(Integer id) throws NotFoundException;

    Goods save(Goods goods);

    List<Goods> getAll();

}
