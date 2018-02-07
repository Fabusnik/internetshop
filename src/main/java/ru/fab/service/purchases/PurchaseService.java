package ru.fab.service.purchases;


import ru.fab.model.Purchase;
import ru.fab.util.exception.NotFoundException;

import java.util.List;

public interface PurchaseService {
    Purchase get(Integer id) throws NotFoundException;

    void delete(Integer id) throws NotFoundException;

    Purchase save(Purchase goods);

    List<Purchase> getAll();


}
