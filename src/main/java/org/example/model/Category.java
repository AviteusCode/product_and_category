package org.example.model;

import java.util.List;

public record Category(String name, String Description, List<Category> categories, List<Product> products) {
}
