package ru.fab.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase")
public class Purchase extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    //user_id
    private User user;

    @ManyToOne
    @JoinColumn(name = "good_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //good_id
    private Goods goods;

    @Column(name = "data")
    private LocalDateTime datePurchase;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "amount")
    private Integer amount;

    public Purchase(){
    }

    public Purchase(User user, Goods goods, LocalDateTime datePurchase, Integer cost, Integer amount){
        this(null, user, goods, datePurchase, cost, amount);
    }

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
