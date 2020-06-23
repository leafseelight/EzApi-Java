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

    /**
     *获取设备列表
     * @throws IOException
     */
    @Test
    void executeApi2() throws IOException {
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
    void executeApi3() throws IOException {
        GetDeviceInfoApi getDeviceInfoApi = new GetDeviceInfoApi(token, "D59433456");
        BasicResponse<DeviceInfoResponse> responseBasicResponse = getDeviceInfoApi.executeApi();
        assertEquals(responseBasicResponse.getCode(),StatusConstant.OK);
        System.out.println(JSON.toJSONString(responseBasicResponse));
    }

    /**
     * 创建子账号
     * @throws IOException
     */
    @Test
    void executeApi4() throws IOException {
        CreateAccountApi createAccountApi = new CreateAccountApi(token,appKey,"light1","123456");
        BasicResponse<CreateAccountResponse> basicResponse = createAccountApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
        //{"code":"200","data":{"accountId":"0e2406c2cc564dbc9752d2609f6680b6"},"msg":"操作成功!"}
    }

    /**
     * 查询子账号信息
     * @throws IOException
     */
    @Test
    void executeApi5() throws IOException {
        GetAccountInfoApi getAccountInfoApi = new GetAccountInfoApi(token,"0e2406c2cc564dbc9752d2609f6680b6","light1");
        BasicResponse<AccountInfoResponse> basicResponse = getAccountInfoApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }

    /**
     * 查询子账号列表
     * @throws IOException
     */
    @Test
    void executeApi6() throws IOException {
        GetAccountListApi getAccountListApi = new GetAccountListApi(token,0,20);
        BasicResponse<List<AccountInfoResponse>> basicResponse = getAccountListApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }
}