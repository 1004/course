package com.xky.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xky.course.entry.Test;
import org.springframework.stereotype.Repository;

/**
 * 配置文件配置了扫描包路径，所以可以识别mapper
 * @Reponsity 这个作用不也是扫码组件的作用吗？
 *
 */
@Repository
public interface TestMapper extends BaseMapper<Test> {
    public void insertSample();
}
