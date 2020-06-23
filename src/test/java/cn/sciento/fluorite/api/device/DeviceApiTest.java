package cn.sciento.fluorite.api.device;


import cn.sciento.fluorite.api.account.CreateAccountApi;
import cn.sciento.fluorite.api.account.GetAccountInfoApi;
import cn.sciento.fluorite.api.account.GetAccountListApi;
import cn.sciento.fluorite.api.device.query.GetDeviceInfoApi;
import cn.sciento.fluorite.api.device.query.GetDeviceListApi;
import cn.sciento.fluorite.api.token.GetToken;
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


class DeviceApiTest {

    private static String appKey;

    private static String appSecret;

    private static String token;

    @BeforeAll
    static void init () throws IOException {
        URL url  = DeviceApiTest.class.getClassLoader().getResource("config.properties");
        InputStream in = DeviceApiTest.class.getClassLoader().getResourceAsStream("config.properties");
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
     *获取设备列表
     * @throws IOException
     */
    @Test
    void executeApi1() throws IOException {
        GetDeviceListApi getDeviceListApi = new GetDeviceListApi(token, 0,20);
        BasicResponse<List<DeviceListResponse>> responseBasicResponse = getDeviceListApi.executeApi();
        assertEquals(responseBasicResponse.getCode(),StatusConstant.OK);
        System.out.println(JSON.toJSONString(responseBasicResponse));
    }

    /***
     * 获取设备详情
     * @throws IOException
     */
    @Test
    void executeApi2() throws IOException {
        GetDeviceInfoApi getDeviceInfoApi = new GetDeviceInfoApi(token, "D59433456");
        BasicResponse<DeviceInfoResponse> responseBasicResponse = getDeviceInfoApi.executeApi();
        assertEquals(responseBasicResponse.getCode(),StatusConstant.OK);
        System.out.println(JSON.toJSONString(responseBasicResponse));
    }


}