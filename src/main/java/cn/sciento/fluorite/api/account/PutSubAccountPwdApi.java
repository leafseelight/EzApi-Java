package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
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
public class PutSubAccountPwdApi extends AbstractAPI {


    private String accountId;//子账号名称
    private String oldPassword;//子账号密码[LowerCase(MD5(AppKey#密码明文))：对AppKey、#和明文密码拼接起来的字符串进行MD5加密，并转成小写]
    private String newPassword;//子账号密码[LowerCase(MD5(AppKey#密码明文))：对AppKey、#和明文密码拼接起来的字符串进行MD5加密，并转成小写]
    private HttpPostMethod httpMethod;//请求方式


    public PutSubAccountPwdApi(String accessToken, String appkey, String accountId, String oldPassword, String newPassword) {
        this.url = ServerConstant.PUT_SUBACCOUNT_PWD;
        this.accessToken = accessToken;
        this.accountId = accountId;
        this.oldPassword = DigestUtils.md5Hex(appkey + "#" + oldPassword).toLowerCase();
        this.newPassword = DigestUtils.md5Hex(appkey + "#" + newPassword).toLowerCase();

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);
        Map<String,Object> params = new HashMap<>();
        if (accessToken != null) {
            params.put("accessToken",this.accessToken);
        }
        if (accountId != null) {
            params.put("accountId",this.accountId);
        }
        if(oldPassword!=null){
            params.put("oldPassword",this.oldPassword);
        }
        if(newPassword!=null){
            params.put("newPassword",this.newPassword);
        }
        httpMethod.setCompleteUrl(url,params);
    }

    public BasicResponse executeApi() {
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
