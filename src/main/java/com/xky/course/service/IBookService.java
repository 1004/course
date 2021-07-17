package com.xky.course.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xky.course.entry.Book;

public interface IBookService {
    /**
     * 分页查询
     *
     * @param page
     * @param rows
     * @return
     */
    public IPage<Book> paging(Integer page, Integer rows);

    public Book queryBookById(Long id);

    public void updateEvaluation();
}
