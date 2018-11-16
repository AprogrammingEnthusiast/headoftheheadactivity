package com.yiscn.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiscn.common.bean.RestResultVo;
import com.yiscn.common.bean.WeiXinUserBo;
import com.yiscn.common.http.HttpClient;
import com.yiscn.common.util.RestResultVoBuilder;
import com.yiscn.common.util.ShaUtil;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 微信业务
 */
public class WeiXinService implements IWeiXinService {
    private Map<String,String> accessTokenMap = new HashMap<>();
    private Map<String,String> ticketMap = new HashMap<>();
    private String APP_ID;
    private String APP_SECRET;
    //获取accessToken(获取用户数据)
    private String USER_ACCESS_TOKEN_URL ="https://api.weixin.qq.com/sns/oauth2/access_token";
    //刷新accessToken(获取用户数据)
    private String USER_REFRESH_TOKEN_URL ="https://api.weixin.qq.com/sns/oauth2/refresh_token";
    //获取用户数据
    private  String USER_GET_USER_INFO_URL ="https://api.weixin.qq.com/sns/userinfo";
    //检查token
    private String USER_CHECK_ACCESS_TOKEN_URL ="https://api.weixin.qq.com/sns/auth";
    //获取ticket
    private  String GET_TICKET_URL ="https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    //获取accessToken的url(用于定位参数的获取等其他接口的调用)
    private String ACCESS_TOKEN_URL;
    //判断用户是否关注公众号的url
    private String HAVE_GUAN_ZHU_URL="https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN";
    @Autowired
    private HttpClient httpClient;

    public WeiXinService(String appId, String appSecret){
        this. APP_ID = appId;
        this.APP_SECRET = appSecret;
        this.ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ APP_ID+"&secret="+APP_SECRET;
    }
    /**
     *获取accessToken和openId
     * @param appId
     * @param secret
     * @param code
     * @return
     * @throws Exception
     */
    private String getAccessToken(String appId, String secret, String code) throws Exception{
        Map<String,String>  params = new HashMap();
        params.put("appid",appId);
        params.put("secret",secret);
        params.put("code",code);
        params.put("grant_type","authorization_code");
        String s = httpClient.doGet(USER_ACCESS_TOKEN_URL, params, null, "UTF-8");
        return s;
    }

    /**
     * 刷新token
     * @param refreshToken
     * @param appId
     * @return
     * @throws Exception
     */

    private String refreshToken(String refreshToken, String appId)throws Exception {
       // String uri = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+appId+"&grant_type=refresh_token&refresh_token="+refreshToken;
        Map<String,String>  params = new HashMap();
        params.put("appid",appId);
        params.put("refresh_token",refreshToken);
        params.put("grant_type","refresh_token");
        String result = httpClient.doGet(USER_REFRESH_TOKEN_URL, params, null, "UTF-8");
        return result;
    }

    /**
     * 获取用户数据
     * @param accessToken
     * @param openId
     * @return
     * @throws Exception
     */
    private String getUserInfo(String accessToken, String openId) throws Exception{
       // String uri = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openId+"&lang=zh_CN";
        Map<String,String>  params = new HashMap();
        params.put("access_token",accessToken);
        params.put("openid",openId);
        params.put("lang","zh_CN");
        String result = httpClient.doGet(USER_GET_USER_INFO_URL, params, null, "UTF-8");
        return result;
    }

     private boolean checkAccessToken(String accessToken, String openId)throws Exception {
        //String uri = "https://api.weixin.qq.com/sns/auth?access_token="+accessToken+"&openid="+openId;
         Map<String,String>  params = new HashMap();
         params.put("access_token",accessToken);
         params.put("openid",openId);
         String s  = httpClient.doGet(USER_CHECK_ACCESS_TOKEN_URL, params, null, "UTF-8");
        JSONObject jsonObject = JSON.parseObject(s);
        Integer errcodeObj = jsonObject.getInteger("errcode");
        if( errcodeObj!=null && errcodeObj.intValue() == 0){
            return  true;
        }
        return  false;
    }

    /**
     * 授权获取用户数据
     * @param code
     * @return 用户对象
     */
    @Override
    public WeiXinUserBo oauth(String code) throws Exception {
        String appId = this.APP_ID;
        String secret = this.APP_SECRET;
        //获取accessToken
        SpringBootLogger.info("授权获取accessToken和openId");
        String access = getAccessToken(appId, secret, code);
        if (access == null) {
            access = getAccessToken(appId, secret, code);
            if (access == null) {
                SpringBootLogger.info("WeiXinServiceImp->oauth,获取accessToken和openId失败");
                throw new RuntimeException("微信授权获取accessToken失败");
            }
        }
        //access:{"access_token":"aX1ugsdqcg_s_PwJHxP4buUzyu07S_zEiGgNgZfLJhXbkLrPUp_imTlQyFEyC9RKW3APWkPe2_NSsHqnJRJddQ","expires_in":7200,"refresh_token":"WbeY5RcVMg2WpRllir4qW40V-srLK0Mpnv37lyVoeMYPKGIW_TdNxGkyyM-MvAyf6HGsnc7XvPUx7MbBWPCcuw","openid":"o-H55t-EkZf3zxpdXZxBlgHLSz38","scope":"snsapi_userinfo"}
        SpringBootLogger.info("已经获取accessToken和openId");
        SpringBootLogger.info("access:" + access);
        JSONObject jsonObject = JSON.parseObject(access);
        String accessToken = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");
        if (accessToken == null || openid == null) {
            SpringBootLogger.info("accessToken:" + accessToken + ",openid:" + openid);
            throw new RuntimeException("微信授权获取accessToken失败");

        }

        //判断accessToken是否有效
        //如果无效,重新获取
        if (checkAccessToken(accessToken, openid)) {
            String refreshToken = jsonObject.getString("refresh_token");
            String s = refreshToken(refreshToken, appId);
            JSONObject jsonObject2 = JSON.parseObject(s);
            accessToken = jsonObject2.getString("access_token");
            openid = jsonObject2.getString("openid");
        }
        //获取用户信息
        String userInfo = getUserInfo(accessToken, openid);
        SpringBootLogger.info("userInfo:" + userInfo);
        Map<String, Object> userInfoMap = (Map<String, Object>) JSON.parse(userInfo);
        //openId
        String openId = (String) userInfoMap.get("openid");
        //昵称
        String nickName = (String) userInfoMap.get("nickname");

        if (openId == null || "".equals(openId)) {
            throw new RuntimeException("微信授权获取openid失败");
        }

       // String province = (String) userInfoMap.get("province")+"省";
      //  String city = (String) userInfoMap.get("city")+"市";

        // String country = (String) userInfoMap.get("country");
        //String address = province+province;
        String headimgurl = (String) userInfoMap.get("headimgurl");
        WeiXinUserBo userBo = new WeiXinUserBo();
        userBo.setOpenid(openid);
        userBo.setHeadImage(headimgurl);
        if(nickName == null){
            nickName = "";
        }
        userBo.setNickname(nickName.getBytes("utf-8"));
        return userBo;
    }

    /**
     * 只获取openid
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public String oauthGetOpenId(String code) throws Exception {
        String appId = this.APP_ID;
        String secret = this.APP_SECRET;
        //获取accessToken
        SpringBootLogger.info("获取accessToken和openId");
        String access = getAccessToken(appId, secret, code);
        if (access == null) {
                throw new RuntimeException("微信授权获取accessToken失败");
        }
        //access:{"access_token":"aX1ugsdqcg_s_PwJHxP4buUzyu07S_zEiGgNgZfLJhXbkLrPUp_imTlQyFEyC9RKW3APWkPe2_NSsHqnJRJddQ","expires_in":7200,"refresh_token":"WbeY5RcVMg2WpRllir4qW40V-srLK0Mpnv37lyVoeMYPKGIW_TdNxGkyyM-MvAyf6HGsnc7XvPUx7MbBWPCcuw","openid":"o-H55t-EkZf3zxpdXZxBlgHLSz38","scope":"snsapi_userinfo"}
        SpringBootLogger.info("已经获取accessToken和openId");
        SpringBootLogger.info("access:" + access);
        JSONObject jsonObject = JSON.parseObject(access);
        String accessToken = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");
        if (accessToken == null || openid == null) {
            SpringBootLogger.info("accessToken:" + accessToken + ",openid:" + openid);
            throw new RuntimeException("微信授权获取accessToken失败");

        }
        return openid;
    }

    /**
     * 获取微信js sdk 调用 需要的jsTickets 参数
     * @param clientUrl
     * @return
     * @throws Exception
     */
    @Override
    public RestResultVo<Object> getTickets(String clientUrl) throws Exception {
        String  ticket = getTicket();
        String nonceStr = StringUtil.getRandomString(15);
        String timestamp = System.currentTimeMillis() / 1000 + "";

        SortedMap<String,String> mapParams = new TreeMap<>();
        mapParams.put("noncestr",nonceStr);
        mapParams.put("jsapi_ticket",ticket);
        mapParams.put("timestamp",timestamp);
        mapParams.put("url",clientUrl);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : mapParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        String stringSignTemp = sb.substring(0,sb.length()-1);
        SpringBootLogger.info("定位签名的字符串:"+stringSignTemp);
        String sign = ShaUtil.SHA1(stringSignTemp);
        //签名
        mapParams.put("sign", sign);
        return RestResultVoBuilder.getSuccessVo(mapParams);
    }

    /**
     * 判断用户是否关注公众号
     * @param openid
     * @return
     */
    @Override
    public boolean isGuanZhu(String openid) throws Exception {
        Map<String,String> params = new HashMap<>();
        params.put("access_token",getAccessToken());
        params.put("openid",openid);
        String resultString = httpClient.doGet(HAVE_GUAN_ZHU_URL,params,null,"utf-8");
        SpringBootLogger.info(openid+"判断是否关注公众号返回:"+resultString);
        JSONObject jsonObject = JSON.parseObject(resultString);
        int subscribe = jsonObject.getIntValue("subscribe");
        return subscribe == 1 ;
    }

    /**
     * 获取accessToken
     * @return
     */

    private String getAccessToken() throws Exception {
        String accessToken = accessTokenMap.get("access_token");
        String time =  accessTokenMap.get("time");
        if(accessToken == null){
            refreshAccessToken();
            return accessTokenMap.get("access_token");
            //7200秒超时，这里设置成7000秒
        }else if((System.currentTimeMillis() - Long.parseLong(time)) > (7000 * 1000)){
            refreshAccessToken();
            return accessTokenMap.get("access_token");
        }else{
            return accessToken;
        }
    }


    private  void refreshAccessToken() throws Exception{
            SpringBootLogger.info("accessTokenUrl:"+ACCESS_TOKEN_URL);
            String s = httpClient.doGet(ACCESS_TOKEN_URL, null, null, "UTF-8");
            //SpringBootLogger.info("获取微信accessToken返回"+s);
            //{"access_token":"gj-BY4dXusaG4GJ_pVC8SOCXV_BH9d6wJgkZlp7s4dH-HvINgWw-0d-ARWcnlMyBn2OtmNY5Sxi4JdaGQcZW_mlNt4LR7nAJf8El-oOZXlaICqxLNBXmdD6dTKpno8bNLIHhAAAXUT","expires_in":7200}
            JSONObject jsonObject = JSON.parseObject(s);
            String accessToken = jsonObject.getString("access_token");
            if(accessToken == null){
                throw new RuntimeException("获取access_token失败，返回结果:"+s);
            }
            //Integer expire = jsonObject.getInteger("expires_in");
            SpringBootLogger.info("accessToken:"+accessToken);
            accessTokenMap.put("access_token",accessToken);
            accessTokenMap.put("time",System.currentTimeMillis()+"");

    }


    private String getTicket() throws Exception{
        String ticket = ticketMap.get("ticket");
        String time = ticketMap.get("time");
        if(ticket == null){
            refreshTicket();
            return ticketMap.get("ticket");
        }else if((System.currentTimeMillis() - Long.parseLong(time)) > (7000 * 1000)){
            refreshTicket();
            return ticketMap.get("ticket");
        }else{
            return ticketMap.get("ticket");
        }
    }

    private void refreshTicket() throws Exception{
        String accessToken = getAccessToken();
        //String accessToken = jiaoZiService.getWeiChatAccessToken();//娇子公社的accessToken

        // String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
        Map<String,String>  params = new HashMap();
        params.put("access_token",accessToken);
        params.put("type","jsapi");
        String s =  httpClient.doGet(GET_TICKET_URL,params,null,"UTF-8");
        JSONObject jsonObject = JSON.parseObject(s);
        String  ticket = jsonObject.getString("ticket");
        ticketMap.put("ticket",ticket);
        ticketMap.put("time",System.currentTimeMillis()+"");

    }
}
