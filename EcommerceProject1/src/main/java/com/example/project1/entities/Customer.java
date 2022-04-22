package com.example.project1.entities;

//import org.springframework.security.access.method.P;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="user_id")
public class Customer extends User{

    private long contact;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<ProductReview> productReview;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order1> order;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @OneToOne(mappedBy = "customers")
     private Cart cart;

    public List<Order1> getOrder() {
        return order;
    }

    public void setOrder(List<Order1> order) {
        this.order = order;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public List<ProductReview> getProductReview() {
        return productReview;
    }

    public void setProductReview(List<ProductReview> productReview) {
        this.productReview = productReview;
    }

}
