package ru.fab.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.model.Purchase;
import ru.fab.repository.PurchaseRepository;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DataJpaPurchaseRepositoryImpl implements PurchaseRepository {

    @Autowired
    private CrudPurchaseRepository repository;

    @Override
    public Purchase get(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    @Transactional
    public Purchase save(Purchase purchase) {
        return repository.save(purchase);
    }

    @Override
    public List<Purchase> getAll() {
        return repository.findAll();
    }
}
