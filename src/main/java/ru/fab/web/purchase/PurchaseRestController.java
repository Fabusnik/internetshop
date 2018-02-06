package ru.fab.web.purchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fab.model.Purchase;
import ru.fab.service.purchases.PurchaseService;

import java.util.List;


@RestController
public class PurchaseRestController {
    private static final Logger log = LoggerFactory.getLogger(PurchaseRestController.class);

    @Autowired
    private PurchaseService service;

    @GetMapping(value = "/purchases")
    public List<Purchase> getAll(){
        return service.getAll();
    }
}
