package com.example.model;


import javax.persistence.*;

@Entity
@Table(name = "basket")
public class BasketComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "count")
    private int count;
    @Column(name = "price")
    private int price;
    @Column(name = "components_id")
    private int components_id;
    @ManyToOne
    @JoinColumn(name = "components_id", nullable = false, insertable = false, updatable = false)
    private ComponentForRecipes component;

    public BasketComponent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getComponents_id() {
        return components_id;
    }

    public void setComponents_id(int components_id) {
        this.components_id = components_id;
    }
}
