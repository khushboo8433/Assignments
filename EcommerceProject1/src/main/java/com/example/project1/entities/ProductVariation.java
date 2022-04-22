package com.example.project1.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.criteria.Order;

@Entity
public class ProductVariation {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private int quantityAvailable;
    private int price;
    private String primaryImageName;
    private boolean isActive;
    @Type(type = "org.hibernate.type.TextType")
    private String metadata;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Product_id")
    private Product product;
    @OneToOne(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private OrderProduct orderProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cart_id")
    private Cart carts;

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPrimaryImageName() {
        return primaryImageName;
    }

    public void setPrimaryImageName(String primaryImageName) {
        this.primaryImageName = primaryImageName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(Category c) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(c);
        setMetadata(s);
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
