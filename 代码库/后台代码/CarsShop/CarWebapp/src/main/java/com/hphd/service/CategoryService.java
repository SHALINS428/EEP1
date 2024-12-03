package com.hphd.service;

import com.hphd.dao.CategoryMapper;
import com.hphd.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    // 获取所有类目
    public List<Category> getAllCategories() {
        return categoryMapper.findAll();
    }

    // 根据ID删除类目
    @Transactional
    public boolean deleteCategoryById(Integer id) {
        int rowsAffected = categoryMapper.deleteById(id);
        if (rowsAffected <= 0) {
            throw new RuntimeException("删除类目失败，ID不存在：" + id);
        }
        return true;
    }

    // 添加新类目
    @Transactional
    public Category addCategory(Category category) {
        System.out.println("Inserting Category: " + category);
        int result = categoryMapper.insert(category);
        System.out.println("Insert Result: " + result); // 打印插入结果
        if (result > 0) {
            return category;
        } else {
            throw new RuntimeException("插入失败！");
        }
    }


}
