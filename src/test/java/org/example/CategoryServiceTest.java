package org.example;

import org.example.model.Category;
import org.example.model.Product;
import org.example.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryServiceTest {

    private CategoryService categoryService = new CategoryService();

    @Test
    public void createCategory(){
        //given
        final String name = "category";
        final String description = "category";

        Category expected = new Category(name, description, new ArrayList<>(), new ArrayList<>());

        //when
        Category result = categoryService.createCategory(name, description);

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
        Product result = categoryService.createProduct(name, price, quantity);

        //then.
         Assertions.assertEquals(expected,result);

    }

    @Test
    public void updateCategory(){
        //given
        final String name = "category";
        final String oldDescription = "category";
        final String newDescription = "new category";


        Category oldCategory = new Category(name, oldDescription, new ArrayList<>(), new ArrayList<>());
        Category expected = new Category(name, newDescription, new ArrayList<>(), new ArrayList<>());

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(oldCategory);
        Category mainCategory = new Category("","", categories, List.of());
        //when
        Category result = categoryService.updateCategory(mainCategory, new ArrayList<>(), name, expected);

        //then.
         Assertions.assertEquals(expected,result.categories().get(0));
    }

    @Test
    public void updateProduct(){
        //given
        final String name = "category";
        final float price = 2.54f;
        final int quantity = 5;
        final int newquantity = 15;

        Product oldProduct = new Product(name, price, quantity);
        List<Product> list = new ArrayList<>();
        list.add(oldProduct);
        Category oldCategory = new Category(name, "description", new ArrayList<>(), list);

        Product expected = new Product(name, price, newquantity);

        //when
        Category result = categoryService.updateProduct(oldCategory, new ArrayList<>(), name, expected);

        //then.
         Assertions.assertEquals(1,result.products().size());
         Assertions.assertEquals(expected,result.products().get(0));

    }

    @Test
    public void deleteCategory(){

        //given
        Category categoryToDelete = new Category("alive", "to Delete", new ArrayList<>(), new ArrayList<>());
        Category keep = new Category("side", "to Keep", new ArrayList<>(), new ArrayList<>());
        List<Category> initialList = new ArrayList<>();
        initialList.add(keep);
        initialList.add(categoryToDelete);
        Category initial = new Category("top", "top category", initialList, new ArrayList<>());
        Category expected = new Category("top", "top category", Arrays.asList(keep), new ArrayList<>());

        //when
        Category result = categoryService.deleteCategory(initial,List.of(), "alive");

        //then.
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void deleteProduct(){

        //given
        Product productToDelete = new Product("alive", 0.35f, 4);
        Product keep = new Product("side", 2.3f, 0);
        List<Product> initialList = new ArrayList<>();
        initialList.add(keep);
        initialList.add(productToDelete);
        Category initial = new Category("top", "top category", new ArrayList<>(), initialList);
        Category expected = new Category("top", "top category", new ArrayList<>(), Arrays.asList(keep));

        //when
        Category result = categoryService.deleteProduct(initial, new ArrayList<>(), "alive");

        //then.
         Assertions.assertEquals(expected,result);
    }

    @Test
    public void linkTwoCategory(){
        //given


        Category categoryToAdd = new Category("alive", "to Add", new ArrayList<>(), new ArrayList<>());
        Category keep = new Category("side", "to Keep", new ArrayList<>(), new ArrayList<>());
        List<Category> initialList = new ArrayList<>();
        initialList.add(keep);
        Category initial = new Category("top", "top category", initialList, new ArrayList<>());
        Category expected = new Category("top", "top category", Arrays.asList(keep,categoryToAdd), new ArrayList<>());

        //when
        Category result = categoryService.linkCategory(initial, new ArrayList<>(), categoryToAdd);

        //then.
         Assertions.assertEquals(expected,result);

    }

    @Test
    public void linkProductAndCategory(){
        //given
        Product productToAdd = new Product("alive", 0.35f, 4);
        Product keep = new Product("side", 2.3f, 0);
        List<Product> initialList = new ArrayList<>();
        initialList.add(keep);
        Category initial = new Category("top", "top category", new ArrayList<>(), initialList);
        Category expected = new Category("top", "top category", new ArrayList<>(),Arrays.asList(keep, productToAdd));

        //when
        Category result = categoryService.linkProduct(initial, new ArrayList<>(), productToAdd);

        //then.
         Assertions.assertEquals(expected,result);

    }

}
