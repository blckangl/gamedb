package com.example.gamedb.services;

import com.example.gamedb.models.Category;
import com.example.gamedb.models.Genre;
import com.example.gamedb.models.Platform;
import com.example.gamedb.repositories.CategoryRepository;
import com.example.gamedb.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public interface CategoryService {



    ArrayList<Category> getCategories();
    Category getById(long id);

    Category createCategory(Category category);

    void deleteCategory(long id);

    Category updateCategory(long id, Category category);
}
