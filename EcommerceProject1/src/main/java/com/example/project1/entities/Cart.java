package com.example.project1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    //incomplete
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_user_id")
    @MapsId
    private Customer customers;

    private int quantity;

    private boolean isWishlistItem;

    @OneToMany(mappedBy = "carts", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinColumn(name = "product_variation_id")
    private List<ProductVariation> productVariation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isWishlistItem() {
        return isWishlistItem;
    }

    public void setWishlistItem(boolean wishlistItem) {
        isWishlistItem = wishlistItem;
    }

    public List<ProductVariation> getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(List<ProductVariation> productVariation) {
        this.productVariation = productVariation;
    }
}
