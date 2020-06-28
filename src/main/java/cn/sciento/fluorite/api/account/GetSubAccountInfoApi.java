package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.account.AccountInfoResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Api文档:http://open.ys7.com/doc/zh/book/index/account-api.html
 */
public class GetSubAccountInfoApi extends AbstractAPI {


    private String accountId;//子账号名称
    private String accountName;//子账号名称
    private HttpPostMethod httpMethod;//请求方式

    public GetSubAccountInfoApi(String accessToken, String accountId, String accountName) {
        this.url = ServerConstant.GET_SUBACCOUNT_INFO;
        this.accessToken = accessToken;
        this.accountId = accountId;
        this.accountName = accountName;

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
        if(accountName!=null){
            params.put("accountName",this.accountName);
        }
        httpMethod.setCompleteUrl(url,params);
    }

    public BasicResponse<AccountInfoResponse> executeApi() {
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
