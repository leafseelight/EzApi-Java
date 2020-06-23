package cn.sciento.fluorite.api.account;


import cn.sciento.fluorite.api.token.GetToken;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountApiTest {

    private static String appKey;

    private static String appSecret;

    private static String token;

    @BeforeAll
    static void init () throws IOException {
        URL url  = AccountApiTest.class.getClassLoader().getResource("config.properties");
        InputStream in = AccountApiTest.class.getClassLoader().getResourceAsStream("config.properties");
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
     * 创建子账号
     * @throws IOException
     */
    @Test
    void executeApi1() throws IOException {
        CreateSubAccountApi createSubAccountApi = new CreateSubAccountApi(token,appKey,"light1","123456");
        BasicResponse<CreateAccountResponse> basicResponse = createSubAccountApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
        //{"code":"200","data":{"accountId":"0e2406c2cc564dbc9752d2609f6680b6"},"msg":"操作成功!"}
    }

    /**
     * 查询子账号信息
     * @throws IOException
     */
    @Test
    void executeApi2() throws IOException {
        GetSubAccountInfoApi getSubAccountInfoApi = new GetSubAccountInfoApi(token,"0e2406c2cc564dbc9752d2609f6680b6","light1");
        BasicResponse<AccountInfoResponse> basicResponse = getSubAccountInfoApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }

    /**
     * 查询子账号列表
     * @throws IOException
     */
    @Test
    void executeApi3() throws IOException {
        GetSubAccountListApi getSubAccountListApi = new GetSubAccountListApi(token,0,20);
        BasicResponse<List<AccountInfoResponse>> basicResponse = getSubAccountListApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }

    /**
     * 修改密码测试
     * @throws IOException
     */
    @Test
    void executeApi4() throws IOException {
        PutSubAccountPwdApi putSubAccountPwdApi = new PutSubAccountPwdApi(token,appKey,"0e2406c2cc564dbc9752d2609f6680b6","123456","111111");
        BasicResponse basicResponse = putSubAccountPwdApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }

    /**
     * 授权测试
     * 注意：这里json字段首字母大写很重要
     * @throws IOException
     */
    @Test
    void executeApi5() throws IOException {
        List<String> devList = new ArrayList<>();
        devList.add("D59433456");
        PutSubAccountPolicyApi putSubAccountPolicyApi = new PutSubAccountPolicyApi(token,"0e2406c2cc564dbc9752d2609f6680b6","Get,Update,Real,Replay",devList,null);
        BasicResponse basicResponse = putSubAccountPolicyApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }

    /**
     * 授权增加
     * 注意：这里json字段首字母大写很重要
     * @throws IOException
     */
    @Test
    void executeApi6() throws IOException {
        List<String> devList = new ArrayList<>();
        devList.add("D59433456");
        PutSubAccountStatementApi putSubAccountStatementApi = new PutSubAccountStatementApi(token,"0e2406c2cc564dbc9752d2609f6680b6","Get",devList,null);
        BasicResponse basicResponse = putSubAccountStatementApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }

    /**
     * 删除子账号的授权
     * 注意：这里json字段首字母大写很重要
     * @throws IOException
     */
    @Test
    void executeApi7() throws IOException {
        DelSubAccountStatementApi delSubAccountStatementApi = new DelSubAccountStatementApi(token,"0e2406c2cc564dbc9752d2609f6680b6","D59433456");
        BasicResponse basicResponse = delSubAccountStatementApi.executeApi();
        System.out.println(JSON.toJSONString(basicResponse));
        assertEquals(basicResponse.getCode(),StatusConstant.OK);
    }




}