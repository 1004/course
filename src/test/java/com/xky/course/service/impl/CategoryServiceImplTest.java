package com.xky.course.service.impl;

import com.xky.course.entry.Categroy;
import com.xky.course.service.ICategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceImplTest {

    @Resource //先按照名称来进行查询，最后按照类型进行查询，然后注入
    private ICategoryService iCategoryService;

    @Test
    public void selectAll() {
        List<Categroy> categroys = iCategoryService.selectAll();
        System.out.println("拿到数据：" + categroys);
    }
}