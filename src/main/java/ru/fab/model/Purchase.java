package ru.fab.model;

import java.time.LocalDateTime;

public class Purchase extends AbstractEntity{

    private User user;
    private Goods goods;
    private LocalDateTime datePurchase;
    private Integer cost;
    private Integer amount;

    public Purchase(Integer id, User user, Goods goods, LocalDateTime datePurchase, Integer cost, Integer amount) {
        super(id);
        this.user = user;
        this.goods = goods;
        this.datePurchase = datePurchase;
        this.cost = cost;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public LocalDateTime getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDateTime datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Purchase{id=%d, user=%s, goods=%s, datePurchase=%s, cost=%d, amount=%d}",
                getId(), user, goods, datePurchase, cost, amount);
    }
}
