package cn.sciento.fluorite.api.device.control;


import cn.sciento.fluorite.api.token.GetToken;
import cn.sciento.fluorite.constants.StatusConstant;
import cn.sciento.fluorite.response.AccessToken;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.device.AddIndexVO;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ControlApiTest {

    private static String appKey;

    private static String appSecret;

    private static String token;

    @BeforeAll
    static void init() throws IOException {
        URL url = ControlApiTest.class.getClassLoader().getResource("config.properties");
        InputStream in = ControlApiTest.class.getClassLoader().getResourceAsStream("config.properties");
        Properties p = new Properties();
        p.load(in);
        appKey = (String) p.get("appKey");
        appSecret = (String) p.get("appSecret");
    }

    @BeforeEach
    void getToken() {
        GetToken getToken = new GetToken(appKey, appSecret);
        BasicResponse<AccessToken> response = getToken.executeApi();
        String code = response.getCode();
        assertEquals(code, StatusConstant.OK);
        token = response.getData().getAccessToken();

    }

    /**
     * C6设备才支持
     * 添加预置点
     *
     * @throws IOException
     */
    @Test
    void executeApi1() throws IOException {
        AddIndexApi addIndexApi = new AddIndexApi(token, "D97153721", "0");
        BasicResponse<AddIndexVO> responseBasicResponse = addIndexApi.executeApi();
        System.out.println(JSON.toJSONString(responseBasicResponse));
        assertEquals(responseBasicResponse.getCode(), StatusConstant.OK);
    }

    /**
     * 调用预置点
     *
     * @throws IOException
     */
    @Test
    void executeApi2() throws IOException {
        CallIndexApi callIndexApi = new CallIndexApi(token, "D97153721", "1", "1");
        BasicResponse responseBasicResponse = callIndexApi.executeApi();
        System.out.println(JSON.toJSONString(responseBasicResponse));
        assertEquals(responseBasicResponse.getCode(), StatusConstant.OK);
    }

    /**
     * 清除预置点
     *
     * @throws IOException
     */
    @Test
    void executeApi3() throws IOException {
        ClearIndexApi clearIndexApi = new ClearIndexApi(token, "D97153721", "1", "1");
        BasicResponse responseBasicResponse = clearIndexApi.executeApi();
        System.out.println(JSON.toJSONString(responseBasicResponse));
        assertEquals(responseBasicResponse.getCode(), StatusConstant.OK);
    }


}