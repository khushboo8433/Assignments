package com.example.project1.entities;

//import com.sun.tools.javac.jvm.Gen;

import javax.persistence.*;
//one field left --parent category id
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToOne(mappedBy = "category",cascade = CascadeType.ALL)
    private CategoryMetadataFieldValue categoryMetadataFieldValue;

    @OneToOne
    @JoinColumn(name="parent_category_id")
    private Category parentCategory;

    public CategoryMetadataFieldValue getCategoryMetadataFieldValue() {
        return categoryMetadataFieldValue;
    }

    public void setCategoryMetadataFieldValue(CategoryMetadataFieldValue categoryMetadataFieldValues) {
        this.categoryMetadataFieldValue = categoryMetadataFieldValues;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}
