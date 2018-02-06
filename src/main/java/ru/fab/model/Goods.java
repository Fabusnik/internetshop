package ru.fab.model;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(name = Goods.DELETE, query = "DELETE FROM Goods g WHERE g.id=:id"),
        @NamedQuery(name = Goods.ALL_SORTED, query = "SELECT g FROM Goods g ORDER BY g.name")
})
@Entity
@Table(name = "goods")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Goods extends AbstractEntity{

    public static final String DELETE = "Goods.delete";
    public static final String ALL_SORTED = "Goods.getAllSorted";

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "stock")
    private Integer stock;

    public Goods(){
    }

    public Goods(String name, String description, Integer price, Integer stock){
        this(null,name,description,price,stock);
    }

    public Goods(Integer id, String name, String description, Integer price, Integer stock) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("Goods{id=%d, name='%s', description='%s', price=%d, stock=%d}",
                getId(), name, description, price, stock);
    }
}
