package com.yiscn.util;

import com.yiscn.socket.QualifyingSocket;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * socket集合
 *
 * @author wangj
 * @date 2018/7/10 9:27
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
public class CommonUtil{

    /**
     * 线程安全无序集合
     */
    private CopyOnWriteArraySet<QualifyingSocket> onlionMan =
            new CopyOnWriteArraySet<QualifyingSocket>();

    /**
     * 获取集合人数
     * @return
     */
    public Integer onlionSize(){
        int size = onlionMan.size();
        if(size > 10000){
            System.gc();
        }
        return size;
    }

    /**
     * 通过下标获取一个对象
     * @param id
     * @return
     */
    public QualifyingSocket getSocket(Integer id){
        if(id > onlionSize()) {
            return null;
        }
        Integer num = 1;
        for (QualifyingSocket socket : onlionMan) {
            if(num.equals(id)){
                return socket;
            }
            num ++;
        }
        return null;
    }

    public void removeSocket(QualifyingSocket socket){
        onlionMan.remove(socket);
    }

    public void addSocket(QualifyingSocket socket){
        onlionMan.add(socket);
    }
}
