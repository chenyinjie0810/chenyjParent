package com.chenyj.article.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/5/11 11:40
 * 陈银杰
 */
@Component
@Slf4j
public class TestThread {
    @Async
    public void executeAsyncTask2(Integer i){
        log.info("CustomMultiThreadingService ==> executeAsyncTask2 method: 执行异步任务{} ", i);
    }
}
