package com.example.gamedb.controllers;

import com.example.gamedb.models.Category;
import com.example.gamedb.models.Platform;
import com.example.gamedb.services.CategoryService;
import com.example.gamedb.services.PlatformService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ArrayList<Category> Index() {
        return categoryService.getCategories();
    }

    @DeleteMapping("{id}")
    public ArrayList<Category> delete(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return categoryService.getCategories();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("{id}")
    public Category create(@RequestBody Category category, @PathVariable long id) {
        return categoryService.updateCategory(id, category);
    }
}
