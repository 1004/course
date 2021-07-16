package com.xky.course.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xky.course.entry.Book;
import com.xky.course.entry.Categroy;
import com.xky.course.service.IBookService;
import com.xky.course.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/15 11:15 上午
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private ICategoryService iCategoryService;

    @Resource
    private IBookService iBookService;

    //    @GetMapping("/index")
//    public ModelAndView showIndex() {
//        ModelAndView modelAndView = new ModelAndView("/index");
//        List<Categroy> categroys = iCategoryService.selectAll();
//        modelAndView.addObject("categoryList", categroys);
//        return modelAndView;
//    }
    @GetMapping("/category/index")
    public List<Categroy> showIndex() {
        List<Categroy> categroys = iCategoryService.selectAll();
        return categroys;
    }


    @GetMapping("/query")
    public IPage<Book> selectByPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return iBookService.paging(page, size);
    }

    @GetMapping("/detail")
    public Book queryById(@RequestParam("id") Long id) {
        return iBookService.queryBookById(id);
    }
}
