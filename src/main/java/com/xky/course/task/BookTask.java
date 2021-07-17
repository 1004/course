package com.xky.course.task;

import com.xky.course.service.IBookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 定时任务模块
 *
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/17 11:28 上午
 */
@Component //加入ioc容器管理
public class BookTask {
    @Resource //ioc容器注入进来
    private IBookService iBookService;

    /**
     * 加入调度模块
     */
    @Scheduled(cron = "0 * * * * ?")
    public void updataEva() {
        iBookService.updateEvaluation();
        System.out.println("updataEva：定时任务执行完毕");
    }
}
