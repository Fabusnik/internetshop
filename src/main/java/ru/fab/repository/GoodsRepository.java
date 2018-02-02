package ru.fab.repository;


import ru.fab.model.Goods;
import ru.fab.repository.datajpa.CrudGoodsRepository;

import java.util.List;

public interface GoodsRepository{

    Goods get(Integer id);

    boolean delete(Integer id);

    Goods save(Goods goods);

    List<Goods> getAll();
}
