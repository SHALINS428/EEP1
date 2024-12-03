package com.hphd.test;

import com.hphd.dao.CategoryMapper;
import com.hphd.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryTest {

    @Autowired
    private CategoryMapper mapper;

    @Test
    public void FindAll(){
        List<Category> all = mapper.findAll();
        for (Category category : all) {
            System.out.println(category);
        }
    }
}
