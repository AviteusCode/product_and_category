package org.example;

import org.example.model.Category;
import org.example.model.Product;
import org.example.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryServiceTest {

    private CategoryService categoryService = new CategoryService();

    @Test
    public void createCategory(){
        //given
        final String name = "category";
        final String description = "category";

        Category expected = new Category(name, description, List.of(), List.of());

        //when
        Category result = categoryService.createCategory();

        //then.
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void createProduct(){
        //given
        final String name = "category";
        final float price = 2.54f;
        final int quantity = 5;

        Product expected = new Product(name, price, quantity);

        //when
        Product result = categoryService.createProduct();

        //then.
         Assertions.assertEquals(expected,result);

    }

    @Test
    public void updateCategory(){
        //given
        final String name = "category";
        final String oldDescription = "category";
        final String newDescription = "new category";

        Category expected = new Category(name, newDescription, List.of(), List.of());

        //when
        Category result = categoryService.updateCategory();

        //then.
         Assertions.assertEquals(expected,result);
    }

    @Test
    public void updateProduct(){
        //given
        final String name = "category";
        final float price = 2.54f;
        final int quantity = 5;
        final int newquantity = 15;

        Product expected = new Product(name, price, newquantity);

        //when
        Product result = categoryService.updateProduct();

        //then.
         Assertions.assertEquals(expected,result);

    }

    @Test
    public void deleteCategory(){

        //given
        Category categoryToDelete = new Category("alive", "to Delete", List.of(), List.of());
        Category keep = new Category("side", "to Keep", List.of(), List.of());
        Category initial = new Category("top", "top category", List.of(keep,categoryToDelete), List.of());
        Category expected = new Category("top", "top category", List.of(keep), List.of());

        //when
        Category result = categoryService.deleteCategory();

        //then.
         Assertions.assertEquals(expected,result);
    }

    @Test
    public void deleteProduct(){

        //given
        Product productToDelete = new Product("alive", 0.35f, 4);
        Product keep = new Product("side", 2.3f, 0);
        Category initial = new Category("top", "to Delete", List.of(), List.of(productToDelete,keep));
        Category expected = new Category("top", "top category", List.of(), List.of(keep));

        //when
        Category result = categoryService.deleteProduct();

        //then.
         Assertions.assertEquals(expected,result);
    }

    @Test
    public void linkTwoCategory(){
        //given
        Category categoryToAdd = new Category("alive", "to Add", List.of(), List.of());
        Category keep = new Category("side", "to Keep", List.of(), List.of());
        Category initial = new Category("top", "top category", List.of(keep), List.of());
        Category expected = new Category("top", "top category", List.of(keep,categoryToAdd), List.of());

        //when
        Category result = categoryService.linkCategory();

        //then.
         Assertions.assertEquals(expected,result);

    }

    @Test
    public void linkProductAndCategory(){
        //given
        Product productToAdd = new Product("alive", 0.35f, 4);
        Product keep = new Product("side", 2.3f, 0);
        Category initial = new Category("top", "to Delete", List.of(), List.of(keep));
        Category expected = new Category("top", "top category", List.of(), List.of(keep, productToAdd));

        //when
        Category result = categoryService.linkProduct();

        //then.
         Assertions.assertEquals(expected,result);

    }

}
