package ru.fab.service.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.fab.model.Goods;
import ru.fab.repository.GoodsRepository;
import ru.fab.util.exception.NotFoundException;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);

    private final GoodsRepository repository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Goods get(Integer id) throws NotFoundException {
        log.info("get by id {}", id);
        return repository.get(id);
    }

    @Override
    @CacheEvict(value = "goods", allEntries = true)
    public void delete(Integer id) throws NotFoundException{
        log.info("delete by id {}",id);
       repository.delete(id);
    }

    @Override
    @CacheEvict(value = "goods", allEntries = true)
    public Goods save(Goods goods) {
        log.info("saved {}",goods);
        return repository.save(goods);
    }

    @Override
    @Cacheable("goods")
    public List<Goods> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

}
