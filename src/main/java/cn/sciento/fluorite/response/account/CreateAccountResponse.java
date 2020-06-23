package cn.sciento.fluorite.response.account;

import com.alibaba.fastjson.annotation.JSONField;

public class CreateAccountResponse {
    /**
     * 账号id
     */
    @JSONField(name = "accountId")
    private String accountId;

}
