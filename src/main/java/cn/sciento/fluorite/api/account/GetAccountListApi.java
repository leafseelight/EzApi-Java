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
import java.util.List;
import java.util.Map;

/**
 * Api文档:http://open.ys7.com/doc/zh/book/index/account-api.html
 */
public class GetAccountListApi extends AbstractAPI {


    private int pageStart;//分页起始页，从0开始
    private int pageSize;//分页大小，默认为10，最大为50
    private HttpPostMethod httpMethod;//请求方式

    public GetAccountListApi(String accessToken, int pageStart, int pageSize) {
        this.url = ServerConstant.GET_ACCOUNT_LIST;
        this.accessToken = accessToken;
        this.pageStart = pageStart;
        this.pageSize = pageSize;

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);
        Map<String,Object> params = new HashMap<>();
        if (accessToken != null) {
            params.put("accessToken",this.accessToken);
        }
        if(pageStart>=0){
            params.put("pageStart",this.pageStart);
        }
        if(pageSize>0){
            params.put("pageSize",this.pageSize);
        }
        httpMethod.setCompleteUrl(url,params);
    }

    public BasicResponse<List<AccountInfoResponse>> executeApi() {
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
