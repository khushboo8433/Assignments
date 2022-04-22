package com.example.project1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    private String description;
    private boolean isCancellable;
    private boolean isReturnable;
    private boolean isActive;
    private boolean isDeleted;
    private String brand;
    @ManyToOne()
    @JoinColumn(name = "seller_user_id")
    private Seller seller;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductVariation> productVariation;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductReview> productReview;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Category> category;

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isCancellable() {
        return isCancellable;
    }

    public void setCancellable(boolean cancellable) {
        isCancellable = cancellable;
    }

    public boolean isReturnable() {
        return isReturnable;
    }

    public void setReturnable(boolean returnable) {
        isReturnable = returnable;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<ProductVariation> getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(List<ProductVariation> productVariation) {
        this.productVariation = productVariation;
    }

    public List<ProductReview> getProductReview() {
        return productReview;
    }

    public void setProductReview(List<ProductReview> productReview) {
        this.productReview = productReview;
    }
}
