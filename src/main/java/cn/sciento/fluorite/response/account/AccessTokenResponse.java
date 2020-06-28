package cn.sciento.fluorite.response.account;

import java.io.Serializable;

/**
 * @desc:
 * @date:10:00 2020/6/28
 * @author:leaf
 **/
public class AccessTokenResponse implements Serializable {

    /**
     * accessToken : ra.7jrcjmna8qnqg8d3dgnzs87m4v2dme3l-32enpqgusd-1jvdfe4-uxo15ik0s
     * expireTime : 1470810222045
     */

    private String accessToken;
    private long expireTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
