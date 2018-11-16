package com.yiscn.service;

import com.yiscn.model.ClientAnswerDto;
import com.yiscn.socket.QualifyingSocket;

/**
 *
 *    房间对战接口
 *
 * @author wangj
 * @date 2018/7/10 9:35
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public interface IPvpRoomService {

    /**
     * 处理答题逻辑
     * @param socket
     * @param clientAnswerDto
     */
    void clientAnswer(QualifyingSocket socket, ClientAnswerDto clientAnswerDto);

    /**
     * 主动获取比赛结果并且入库
     * @param socket
     */
    void getResult(QualifyingSocket socket);
}
