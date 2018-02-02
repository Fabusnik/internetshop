package ru.fab.repository.datajpa;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.model.Goods;

import java.util.List;
import java.util.Optional;

public interface CrudGoodsRepository extends JpaRepository<Goods, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Goods g WHERE g.id=?1")
    int delete(Integer id);

    @Override
    Goods save(Goods goods);

    @Override
    Optional<Goods> findById(Integer id);

    @Override
    List<Goods> findAll();
}
