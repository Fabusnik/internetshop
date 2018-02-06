package ru.fab.web.purchase;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fab.model.Purchase;

import java.util.List;

@RequestMapping(value = "/purchases")
public class PurchaseController extends AbstractPurchaseController{

    @PostMapping
    public List<Purchase> getAll(){
        return super.getAll();
    }

}
