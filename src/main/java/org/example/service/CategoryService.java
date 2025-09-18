package org.example.service;

import org.example.model.Category;
import org.example.model.Product;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public Category createCategory(String name, String description){
        return new Category(name, description, new ArrayList<>(), new ArrayList<>());
    }

    public Category updateCategory(Category mainCategory, List<String> path, String categoryName, Category updatedCategory){

        Category categoryToUpdate = runThroughPath(mainCategory, path);

        categoryToUpdate.removeCategory(categoryName);
        categoryToUpdate.addCategory(updatedCategory);

        return mainCategory;
    }

    private static Category runThroughPath(Category mainCategory, List<String> path) {
        Category categoryToUpdate = mainCategory;
        for (String name: path){
            List<Category> childrenCategories = categoryToUpdate.categories().stream().filter(category -> category.name().equals(name)).toList();

            if (childrenCategories.size() != 1){
                throw new InvalidParameterException("invalid path");
            }

            categoryToUpdate = childrenCategories.get(0);
        }
        return categoryToUpdate;
    }

    public Category deleteCategory(Category mainCategory, List<String> path, String categoryName){
        Category categoryToUpdate = runThroughPath(mainCategory, path);

        categoryToUpdate.removeCategory(categoryName);

        return mainCategory;
    }

    public Product createProduct(String name, float price, int quantity){
        return new Product(name, price, quantity);
    }

    public Category updateProduct(Category mainCategory, List<String> path, String productName, Product updatedProduct){

        Category categoryToUpdate = runThroughPath(mainCategory, path);

        categoryToUpdate.removeProduct(productName);
        categoryToUpdate.addProduct(updatedProduct);

        return mainCategory;
    }

    public Category deleteProduct(Category mainCategory, List<String> path, String productName){
        Category categoryToUpdate = runThroughPath(mainCategory, path);

        categoryToUpdate.removeProduct(productName);

        return mainCategory;
    }

    public Category linkCategory(Category mainCategory, List<String> path, Category categoryToAdd){
        Category categoryToUpdate = runThroughPath(mainCategory, path);

        categoryToUpdate.addCategory(categoryToAdd);

        return mainCategory;
    }

    public Category linkProduct(Category mainCategory, List<String> path, Product productToAdd){
        Category categoryToUpdate = runThroughPath(mainCategory, path);

        categoryToUpdate.addProduct(productToAdd);

        return mainCategory;
    }

}
