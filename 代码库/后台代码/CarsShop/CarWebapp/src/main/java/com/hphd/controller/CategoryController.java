package com.hphd.controller;

import com.hphd.model.Category;
import com.hphd.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // 获取所有类目
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // 添加新类目
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        System.out.println("Received Category: " + category); // 打印接收到的数据
        return categoryService.addCategory(category);
    }



    // 删除类目

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
    }

}
