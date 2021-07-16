package com.xky.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xky.course.entry.Book;
import com.xky.course.mapper.BookMapper;
import com.xky.course.service.IBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/15 11:58 上午
 */
@Service("iBookService")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED) //默认不支持事务
public class BookService implements IBookService {
    @Resource
    private BookMapper bookMapper;

    public IPage<Book> paging(Integer page, Integer rows) {
        //分页工具拼装
        Page<Book> p = new Page<Book>(page, rows);
        Page<Book> bookPages = bookMapper.selectPage(p, new QueryWrapper<Book>());
        return bookPages;
    }

    public Book queryBookById(Long id) {
        return bookMapper.selectById(id);
    }
}
