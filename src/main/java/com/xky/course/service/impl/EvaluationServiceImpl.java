package com.xky.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xky.course.entry.Evaluation;
import com.xky.course.mapper.EvaluationMapper;
import com.xky.course.service.IEvaluationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/16 11:02 上午
 */
@Service("iEvaluationService")
public class EvaluationServiceImpl implements IEvaluationService {
    @Resource
    private EvaluationMapper evaluationMapper;

    public List<Evaluation> queryByBookId(Long bookId) {
        QueryWrapper<Evaluation> queryWrapper = new QueryWrapper<Evaluation>();
        queryWrapper.eq("book_id", bookId);
        queryWrapper.eq("state", "enable");
        queryWrapper.orderByDesc("create_time");
        return evaluationMapper.selectList(queryWrapper);
    }
}
