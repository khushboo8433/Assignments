package com.example.project1.entities;

import javax.persistence.*;
import javax.persistence.criteria.Order;

@Entity
public class OrderProduct {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private int Quantity;
        private double price;
        @OneToOne
        @JoinColumn(name ="order_id")
        private Order1 order1;
        @OneToOne
        @JoinColumn(name="product_variation_id")
        private ProductVariation productVariation;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getQuantity() {
                return Quantity;
        }

        public void setQuantity(int quantity) {
                Quantity = quantity;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public Order1 getOrder1() {
                return order1;
        }

        public void setOrder1(Order1 order1) {
                this.order1 = order1;
        }

        public ProductVariation getProductVariation() {
                return productVariation;
        }

        public void setProductVariation(ProductVariation productVariation) {
                this.productVariation = productVariation;
        }
}
