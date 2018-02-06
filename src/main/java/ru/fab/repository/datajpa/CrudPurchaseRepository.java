package ru.fab.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fab.model.Purchase;

import java.util.List;


public interface CrudPurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Override
    List<Purchase> findAll();
}
