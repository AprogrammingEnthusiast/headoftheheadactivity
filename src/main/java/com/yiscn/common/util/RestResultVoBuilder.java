package com.yiscn.common.util;

import com.yiscn.common.bean.RestResultVo;
import com.yiscn.common.bean.StatusCode;

public class RestResultVoBuilder {

    public static<W> RestResultVo getSuccessVo(W data){
        RestResultVo<W> vo = new RestResultVo();
        vo.setData(data);
        return vo;
    }

    public static RestResultVo getSuccessVo(){
        return getSuccessVo(null);
    }

    public  static RestResultVo getErrorVo(StatusCode statusCode, String msg){
        RestResultVo vo = new RestResultVo();
        vo.setStatusCode(statusCode.getCode());
        vo.setStatusMsg(msg);
        return vo;
    }

    public  static RestResultVo getErrorVo(StatusCode statusCode){
        RestResultVo vo = new RestResultVo();
        vo.setStatusCode(statusCode.getCode());
        vo.setStatusMsg(statusCode.getMessage());
        return vo;
    }

}
