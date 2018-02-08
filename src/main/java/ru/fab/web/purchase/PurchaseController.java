package ru.fab.web.purchase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fab.model.Purchase;

import java.util.List;

@Controller
@RequestMapping(value = "/purchases")
public class PurchaseController extends AbstractPurchaseController{

    @GetMapping
    public List<Purchase> getAll(){
        return super.getAll();
    }

}
