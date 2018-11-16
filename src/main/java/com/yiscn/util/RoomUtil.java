package com.yiscn.util;

import com.yiscn.model.Room;
import com.yiscn.socket.QualifyingSocket;

import java.util.concurrent.ConcurrentHashMap;

public class RoomUtil {

    /**
     * 对战房间
     */
    public static ConcurrentHashMap<Integer, Room> room =
            new ConcurrentHashMap<Integer, Room>();


    /**
     * 根据房间id获取房间
     *
     * @param roomId
     * @return
     */
    public static Room getRoom(Integer roomId) {
        return room.get(roomId);
    }

    public static void removeRoom(Integer roomId) {
        RoomUtil.room.remove(roomId);
    }

    public static void removeUser(Integer roomId, QualifyingSocket socket) {
        Room room = RoomUtil.room.get(roomId);
        if (room.getHomeUser().getUid().equals(socket.getUid())) {
            room.setHomeUser(null);
            socket.changeRoomId(0);
            if (room.getAwayUser() == null) {
                removeRoom(roomId);
            }
        } else {
            room.setAwayUser(null);
            socket.changeRoomId(0);
            if (room.getHomeUser() == null) {
                removeRoom(roomId);
            }
        }
    }

}
