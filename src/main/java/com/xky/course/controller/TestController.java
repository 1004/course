package com.xky.course.controller;

import com.xky.course.entry.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/13 10:11 上午
 */
@RestController
@RequestMapping("/course")
public class TestController {

    @GetMapping("/query")
    public Book test() {
        Book course = new Book();
//        course.setName("网络应用");
        return course;
    }

    @GetMapping("/test")
    public String testStr() {
        Book course = new Book();
//        course.setName("网络应用");
        return "hellow";
    }

    @GetMapping("/vm")
    public ModelAndView testVm() {
        ModelAndView mv = new ModelAndView("/test");
        return mv;
    }
}
