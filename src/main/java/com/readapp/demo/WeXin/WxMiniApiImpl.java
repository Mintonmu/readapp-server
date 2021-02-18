package com.readapp.demo.WeXin;

import com.alibaba.fastjson.JSONObject;
import com.readapp.demo.utils.WeChatUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class WxMiniApiImpl implements WxMiniApi {
    @Override
    public JSONObject authCode2Session(String appId, String secret, String jsCode) {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code";
        String str = WeChatUtils.httpRequest(url, "GET", null);
        log.info("api/wx-mini/getSessionKey:" + str);
        if (StringUtils.hasText(str)) {
            return null;
        } else {
            return JSONObject.parseObject(str);
        }

    }

}
