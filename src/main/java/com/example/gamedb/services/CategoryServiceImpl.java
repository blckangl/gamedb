package com.example.gamedb.services;

import com.example.gamedb.models.Category;
import com.example.gamedb.models.Platform;
import com.example.gamedb.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    @Override
    public Category getById(long id) {
      Category cat = categoryRepository.findById(id);
        return cat;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);

        return;
    }

    @Override
    public Category updateCategory(long id, Category category) {
        Category categorytoUpdate = categoryRepository.findById(id);

        if (categorytoUpdate != null) {

            if (category.getTitle() != null)
                categorytoUpdate.setTitle(category.getTitle());

            return categoryRepository.save(categorytoUpdate);
        } else {
            return null;

        }
    }
}
