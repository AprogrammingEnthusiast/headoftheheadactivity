package com.yiscn.service.impl;

import com.yiscn.common.component.ThreadPool;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.service.IQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 队列任务实现
 *
 * @author wangj
 * @date 2018/7/6 11:01
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service
public class QueueServiceImp implements IQueueService {
    @Autowired
    private ThreadPool threadPool;
    /**
     * 队列大小 Integer.MAX
     */
    private BlockingQueue<QueueTask> queue = new LinkedBlockingDeque();
    @Autowired
    private PlatformTransactionManager txManager;

    /**
     * 开启队列任务执行线程
     */
    @PostConstruct
    public void startQueueTaskExecuteThread() {
        threadPool.execute(() -> {
            while (true) {
                try {
                    QueueTask task = queue.take();
                    //使用编程式事物
                    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
                    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
                    TransactionStatus status = txManager.getTransaction(def);
                    try {
                        task.runTask();
                        // 提交事务
                        txManager.commit(status);
                    } catch (Exception e) {
                        e.printStackTrace();
                        SpringBootLogger.error("执行队列任务远异常", e);
                        // 回滚事务
                        txManager.rollback(status);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    SpringBootLogger.error("任务队列取任务异常", e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SpringBootLogger.error("队列任务事物异常", e2);
                }
            }
        });
    }

    @Override
    public void putTask(QueueTask queueTask) {
        try {
            queue.put(queueTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
            SpringBootLogger.error("队列任务入队异常", e);
        }
    }
}
