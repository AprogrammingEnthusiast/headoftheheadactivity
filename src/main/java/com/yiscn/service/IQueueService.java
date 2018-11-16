package com.yiscn.service;

/**
 * 队列中执行的业务
 *
 * @author wangj
 * @date 2018/7/6 10:59
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IQueueService {

    void putTask(QueueTask queueTask);

    interface QueueTask {
        void runTask() throws Exception;
    }
}
