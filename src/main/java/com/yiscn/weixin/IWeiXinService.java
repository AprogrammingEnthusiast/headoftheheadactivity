package com.yiscn.weixin;


import com.yiscn.common.bean.RestResultVo;
import com.yiscn.common.bean.WeiXinUserBo;

public interface IWeiXinService {


    /**
     * 网页授权
     * @param code
     * @return 用户数据
     */
    WeiXinUserBo oauth(String code) throws Exception;

    /**
     * 只获取openId不获取用户信息
     * @param code
     * @return
     */
    String oauthGetOpenId(String code) throws Exception;

    /**
     * 获取微信js sdk 调用需要的jsTickets 参数
     * @param clientUrl
     * @return
     */
    RestResultVo getTickets(String clientUrl) throws Exception;

    /**
     * 判断用户是是否关注公众号
     * @param openid
     * @return
     */
    boolean isGuanZhu(String openid) throws Exception;


}
