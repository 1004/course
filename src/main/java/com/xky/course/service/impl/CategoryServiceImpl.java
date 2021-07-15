package com.xky.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xky.course.entry.Categroy;
import com.xky.course.mapper.CategoryMapper;
import com.xky.course.service.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiekongying
 * @version 1.0
 * <p>
 * 面向接口编程，提高扩展性
 * @date 2021/7/15 10:50 上午
 * IOC 容器存储接口相关的id
 */
@Service("iCategoryService") //自定义id
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)// 默认不支持事务
public class CategoryServiceImpl implements ICategoryService {

    //从ioc 容器中先按照id,在按照类型进行注入
    @Resource
    private CategoryMapper categoryMapper;

    public List<Categroy> selectAll() {
        List<Categroy> categroys = categoryMapper.selectList(new QueryWrapper<Categroy>());
        return categroys;
    }


}
