package ru.fab.web.purchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fab.model.Purchase;
import ru.fab.service.purchases.PurchaseService;

import java.util.List;

public abstract class AbstractPurchaseController {
    protected static final Logger log = LoggerFactory.getLogger(AbstractPurchaseController.class);

    @Autowired
    private PurchaseService service;

    public List<Purchase> getAll(){
        log.info("getAll purchases");
        return service.getAll();
    }

}
