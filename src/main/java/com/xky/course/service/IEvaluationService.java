package com.xky.course.service;

import com.xky.course.entry.Evaluation;

import java.util.List;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/16 11:01 上午
 */
public interface IEvaluationService {
    /**
     * 根据书的id，查询对应的评论
     *
     * @param bookId
     */
    public List<Evaluation> queryByBookId(Long bookId);
}
