package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.account.AccessTokenResponse;
import cn.sciento.fluorite.response.account.CreateAccountResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Api文档:http://open.ys7.com/doc/zh/book/index/account-api.html
 */
public class GetSubAccountAccessTokenApi extends AbstractAPI {

    /**
     * 子账号id
     */
    private String accountId;

    /**
     * 请求方式
     */
    private HttpPostMethod httpMethod;

    public GetSubAccountAccessTokenApi(String accessToken, String accountId) {
        this.url = ServerConstant.GET_SUBACCOUNT_ACCESSTOKEN;
        this.accessToken = accessToken;
        this.accountId = accountId;
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);
        Map<String,Object> params = new HashMap<>();
        if (accessToken != null) {
            params.put("accessToken",this.accessToken);
        }
        if(accountId!=null){
            params.put("accountId",this.accountId);
        }
        httpMethod.setCompleteUrl(url,params);
    }

    public BasicResponse<AccessTokenResponse> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpMethod.execute();
        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(),BasicResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            httpMethod.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
