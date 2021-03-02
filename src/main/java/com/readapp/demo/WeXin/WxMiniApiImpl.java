package com.readapp.demo.WeXin;

import com.alibaba.fastjson.JSONObject;
import com.readapp.demo.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import java.io.IOException;

@Slf4j
public class WxMiniApiImpl implements WxMiniApi {
    @Override
    public JSONObject authCode2Session(String appId, String secret, String jsCode) throws IOException {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code";
        String str = Jsoup.connect(url).get().text();
        log.info("api/wx-mini/getSessionKey:" + str);
        if (StringUtil.isEmpty(str)) {
            return null;
        } else {
            return JSONObject.parseObject(str);
        }

    }

}
