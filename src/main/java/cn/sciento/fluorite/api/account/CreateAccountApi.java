package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.account.CreateAccountResponse;
import cn.sciento.fluorite.utils.DigestUtils;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Api文档:http://open.ys7.com/doc/zh/book/index/account-api.html
 */
public class CreateAccountApi extends AbstractAPI {


    private String accountName;//子账号名称
    private String password;//子账号密码[LowerCase(MD5(AppKey#密码明文))：对AppKey、#和明文密码拼接起来的字符串进行MD5加密，并转成小写]
    private HttpPostMethod httpMethod;//请求方式


    public CreateAccountApi (String accessToken,String appkey,String accountName,String password) {
        this.url = ServerConstant.ADD_ACCOUNT;
        this.accessToken = accessToken;
        this.accountName = accountName;
        this.password = DigestUtils.md5Hex(appkey + "#" + password).toLowerCase();

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);
        Map<String,Object> params = new HashMap<>();
        if (accessToken != null) {
            params.put("accessToken",this.accessToken);
        }
        if(accountName!=null){
            params.put("accountName",this.accountName);
        }
        if(password!=null){
            params.put("password",this.password);
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
