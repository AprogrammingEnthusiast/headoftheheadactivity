package com.yiscn.common.component;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 *
 *    线程池
 *
 * @author wangj
 * @date 2018/7/6 10:38
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Component
public class ThreadPool {

    /*ThreadFactory namedThreadFactory;

    ThreadPool() {
        namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("result-pool-%d").build();
    }

    private ExecutorService cachedThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());*/

    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public void  execute(Runnable runnable){
        cachedThreadPool.execute(runnable);
    }
}
