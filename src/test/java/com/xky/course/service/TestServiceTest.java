package com.xky.course.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xky.course.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 启动自动加载配置文件，初始化IOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServiceTest {

//    IOC 注入进来组件
    @Resource
    private TestService testService;

    @Resource
    private TestMapper testMapper;

    @Test
    public void testPort() {
        testService.testPort();
    }

    @Test
    public void testInsert(){
        testService.testAdd();
    }

    @Test
    public void testQuery(){
        QueryWrapper<com.xky.course.entry.Test> wrapper = new QueryWrapper<com.xky.course.entry.Test>();
        wrapper.eq("id","28");
        List<com.xky.course.entry.Test> tests = testMapper.selectList(wrapper);
        System.out.println(tests);
    }

}