package com.xky.course.service;

import com.xky.course.entry.Test;
import com.xky.course.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/14 9:51 上午
 */
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    @Transactional
    public void testPort() {
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                throw new IllegalArgumentException("ce");
            }
            testMapper.insertSample();
        }
        System.out.println("成功");
    }

    public void testAdd() {
        Test test = new Test();
        test.setContent("好借好还");
        testMapper.insert(test);
    }
}
