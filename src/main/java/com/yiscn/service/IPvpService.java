package com.yiscn.service;

import com.yiscn.model.RequestMessage;
import com.yiscn.model.ResponseMessage;
import com.yiscn.socket.QualifyingSocket;

import java.io.IOException;

/**
 *
 *    排位对战逻辑处理类
 *
 * @author wangj
 * @date 2018/7/9 9:11
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IPvpService {

    /**
     * 开始处理对战逻辑
     * @param requestMessage 客户端的消息对象
     * @param socket
     * @throws IOException
     */
    void start(RequestMessage requestMessage, QualifyingSocket socket) throws IOException;

    Integer joinRoom(QualifyingSocket myself,QualifyingSocket enemy);
}
