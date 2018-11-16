package com.yiscn.common.bean;

import lombok.Data;

@Data
public class WeiXinUserBo {

    /**
     * openid
     */
    private String openid;
    /**
     * 头像
     */
    private String headImage;
    /**
     * 昵称 字节数组（表情符）
     */
    private byte[] nickname;

}
