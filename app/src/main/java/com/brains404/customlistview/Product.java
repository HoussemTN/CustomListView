package com.brains404.customlistview;

public class Product {
    int productImage ;

    String name,description ;

    public Product(int productImage, String name, String description) {
        this.productImage = productImage;
        this.name = name;
        this.description = description;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
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
}
