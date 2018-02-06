package ru.fab.service.purchases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fab.model.Purchase;
import ru.fab.repository.PurchaseRepository;
import ru.fab.util.exception.NotFoundException;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    @Override
    public Purchase get(Integer id) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(Integer id) throws NotFoundException {

    }

    @Override
    public Purchase save(Purchase purchase) {
        return repository.save(purchase);
    }

    @Override
    public List<Purchase> getAll() {
        return repository.getAll();
    }
}
