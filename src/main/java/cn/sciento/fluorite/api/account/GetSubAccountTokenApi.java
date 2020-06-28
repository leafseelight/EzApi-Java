package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
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
public class GetSubAccountTokenApi extends AbstractAPI {

    /**
     * 子账号id
     */
    private String accountId;
    /**
     * 设备序列号
     */
    private String deviceSerial;
    /**
     * 请求方式
     */
    private HttpPostMethod httpMethod;

    public GetSubAccountTokenApi(String accessToken, String accountId, String deviceSerial) {
        this.url = ServerConstant.DEL_SUBACCOUNT_STATEMENT;
        this.accessToken = accessToken;
        this.accountId = accountId;
        this.deviceSerial = deviceSerial;
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
        if(deviceSerial!=null){
            params.put("deviceSerial",this.deviceSerial);
        }
        httpMethod.setCompleteUrl(url,params);
    }

    public BasicResponse<CreateAccountResponse> executeApi() {
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
