package com.hphd.dao;

import com.hphd.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    // 查询所有类目
    List<Category> findAll();

    // 添加新类目
    int insert(Category category);

    // 根据ID删除类目
    int deleteById(Integer id);
}
