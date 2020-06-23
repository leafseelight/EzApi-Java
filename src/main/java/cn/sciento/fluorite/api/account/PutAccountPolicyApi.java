package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.request.PutPolicyVO;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账号授权
 * Api文档:http://open.ys7.com/doc/zh/book/index/account-api.html
 *
 */
public class PutAccountPolicyApi extends AbstractAPI {
    /**
     * 子账号id
     */
    private String accountId;
    /**
     * 授权策略
     */
    private String policy;
    /**
     * 请求方式
     */
    private HttpPostMethod httpMethod;

    /**
     *
     * @param accessToken
     * @param accountId
     * @param permission Get,Update,Real,Replay
     * @param devNumList ["469631729"]
     * @param camNumList ["544229080"]
     */
    public PutAccountPolicyApi(String accessToken, String accountId, String permission, List<String> devNumList, List<String> camNumList) {
        this.url = ServerConstant.PUT_ACCOUNT_POLICY;
        this.accessToken = accessToken;
        this.accountId = accountId;
        PutPolicyVO putPolicyVO = new PutPolicyVO();
        PutPolicyVO.StatementBean statementBean = createStatementBean(permission, devNumList, camNumList);
        List<PutPolicyVO.StatementBean> statementList = new ArrayList<>();
        statementList.add(statementBean);
        putPolicyVO.setStatement(statementList);
        this.policy = JSON.toJSONString(putPolicyVO);
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
        if(policy!=null){
            params.put("policy",this.policy);
        }
        httpMethod.setCompleteUrl(url,params);
    }

    public PutAccountPolicyApi(String accessToken, String accountId, List<PutPolicyVO.StatementBean> statementList) {
        this.url = ServerConstant.PUT_ACCOUNT_POLICY;
        this.accessToken = accessToken;
        this.accountId = accountId;
        PutPolicyVO putPolicyVO = new PutPolicyVO();
        putPolicyVO.setStatement(statementList);
        this.policy = JSON.toJSONString(putPolicyVO);
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
        if(policy!=null){
            params.put("policy",this.policy);
        }
        httpMethod.setCompleteUrl(url,params);
    }

    public PutPolicyVO.StatementBean createStatementBean(String permission, List<String> devNumList, List<String> camNumList) {
        PutPolicyVO.StatementBean statementBean = new PutPolicyVO.StatementBean();
        statementBean.setPermission(permission);
        List<String> resList = new ArrayList<>();
        if(devNumList!=null){
            for (String item:devNumList){
                String str = "dev:"+item;
                resList.add(str);
            }
        }
        if(camNumList!=null) {
            for (String item : camNumList) {
                String str = "cam:" + item;
                resList.add(str);
            }
        }
        statementBean.setResource(resList);
        return statementBean;
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
