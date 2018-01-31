package ru.fab.model;

public class Goods extends AbstractEntity{

    private String name;
    private String description;
    private Integer price;
    private Integer stock;

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
