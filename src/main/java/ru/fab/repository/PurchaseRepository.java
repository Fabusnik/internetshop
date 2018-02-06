package ru.fab.repository;

import ru.fab.model.Purchase;

import java.util.List;

public interface PurchaseRepository {
    Purchase get(Integer id);

    boolean delete(Integer id);

    Purchase save(Purchase goods);

    List<Purchase> getAll();
}
