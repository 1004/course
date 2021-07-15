package com.xky.course.controller;

import com.xky.course.entry.Categroy;
import com.xky.course.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/15 11:15 上午
 */
@RestController
@RequestMapping("/category")
public class BookController {
    @Resource
    private ICategoryService iCategoryService;

    //    @GetMapping("/index")
//    public ModelAndView showIndex() {
//        ModelAndView modelAndView = new ModelAndView("/index");
//        List<Categroy> categroys = iCategoryService.selectAll();
//        modelAndView.addObject("categoryList", categroys);
//        return modelAndView;
//    }
    @GetMapping("/index")
    public List<Categroy> showIndex() {
        List<Categroy> categroys = iCategoryService.selectAll();
        return categroys;
    }
}
