package com.example.project1.entities;

import javax.persistence.*;

@Entity
public class CategoryMetadataFieldValue {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String value;

    @OneToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    @OneToOne
    @JoinColumn(name="category_metadata_field_id",referencedColumnName = "id")
    private CategoryMetadataField categoryMetadataField;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String values) {
        this.value = values;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryMetadataField getCategoryMetadataField() {
        return categoryMetadataField;
    }

    public void setCategoryMetadataField(CategoryMetadataField categoryMetadataField) {
        this.categoryMetadataField = categoryMetadataField;
    }
}
