package org.example.model;

import java.util.List;
import java.util.stream.Collectors;

public record Category(String name, String description, List<Category> categories, List<Product> products) {


    public void removeCategory(String nameTodelete){
        categories.remove(categories.stream().filter(category -> category.name().equals(nameTodelete)).findAny().orElseThrow());
    }


    public void addCategory(Category category){
        categories.add(category);
    }

    public void removeProduct(String nameTodelete){
        products.remove(products.stream().filter(category -> category.name().equals(nameTodelete)).findAny().orElseThrow());
    }


    public void addProduct(Product product){
        products.add(product);
    }
}


