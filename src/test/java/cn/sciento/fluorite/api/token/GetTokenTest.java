package cn.sciento.fluorite.api.token;


import cn.sciento.fluorite.api.account.CreateAccountApi;
import cn.sciento.fluorite.api.account.GetAccountInfoApi;
import cn.sciento.fluorite.api.account.GetAccountListApi;
import cn.sciento.fluorite.api.device.query.GetDeviceInfoApi;
import cn.sciento.fluorite.api.device.query.GetDeviceListApi;
import cn.sciento.fluorite.api.weblive.OpenLive;
import cn.sciento.fluorite.constants.StatusConstant;
import cn.sciento.fluorite.response.*;
import cn.sciento.fluorite.response.account.AccountInfoResponse;
import cn.sciento.fluorite.response.account.CreateAccountResponse;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GetTokenTest {

    private static String appKey;

    private static String appSecret;

    private static String token;

    @BeforeAll
    static void init () throws IOException {
        URL url  = GetTokenTest.class.getClassLoader().getResource("config.properties");
        InputStream in = GetTokenTest.class.getClassLoader().getResourceAsStream("config.properties");
        Properties p = new Properties();
        p.load(in);
        appKey = (String) p.get("appKey");
        appSecret = (String) p.get("appSecret");
    }

    @BeforeEach
    void getToken(){
        GetToken getToken = new GetToken(appKey, appSecret);
        BasicResponse<AccessToken> response = getToken.executeApi();
        String code = response.getCode();
        assertEquals(code, StatusConstant.OK);
        token = response.getData().getAccessToken();

    }

    /**
     * 测试accessToken
     * @throws IOException
     */
    @Test
    void executeApi1() throws IOException {
        String source = "C19813822:1";
        source = URLEncoder.encode(source, String.valueOf(StandardCharsets.UTF_8));
        System.out.println(source);
        OpenLive openLive = new OpenLive(token, source);
        BasicResponse<List<OpenLiveResponse>> responseBasicResponse = openLive.executeApi();
        assertEquals(responseBasicResponse.getCode(),StatusConstant.OK);
    }

}