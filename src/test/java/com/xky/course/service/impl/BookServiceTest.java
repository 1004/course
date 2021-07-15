package com.xky.course.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xky.course.entry.Book;
import com.xky.course.service.IBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceTest {

    @Resource
    private IBookService iBookService;

    @Test
    public void paging() {
        IPage<Book> paging = iBookService.paging(1, 10);
        System.out.println("数据："+paging.getRecords().size());
    }
}