package ru.fab.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.model.Goods;
import ru.fab.repository.GoodsRepository;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DataJpaGoodsRepositoryImpl implements GoodsRepository {
    private static final Sort SORT_BY_PRICE = new Sort(Sort.Direction.ASC,"name");

    @Autowired
    private CrudGoodsRepository repository;

    @Override
    public Goods get(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.delete(id) != 0;
    }

    @Override
    @Transactional
    public Goods save(Goods goods) {
        return repository.save(goods);
    }

    @Override
    public List<Goods> getAll() {
        return repository.findAll(SORT_BY_PRICE);
    }
}
