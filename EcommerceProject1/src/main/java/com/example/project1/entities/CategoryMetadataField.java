package com.example.project1.entities;

import javax.persistence.*;

@Entity
public class CategoryMetadataField {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    @OneToOne(mappedBy = "categoryMetadataField",cascade = CascadeType.ALL)
    private CategoryMetadataFieldValue categoryMetadataFieldValue;

    public CategoryMetadataFieldValue getCategoryMetadataFieldValue() {
        return categoryMetadataFieldValue;
    }

    public void setCategoryMetadataFieldValue(CategoryMetadataFieldValue categoryMetadataFieldValues) {
        this.categoryMetadataFieldValue = categoryMetadataFieldValue;
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
}
