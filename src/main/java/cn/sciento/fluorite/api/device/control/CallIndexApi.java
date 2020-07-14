package cn.sciento.fluorite.api.device.control;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Api文档:http://open.ys7.com/doc/zh/book/index/device_ptz.html#device_ptz-api4
 */
public class CallIndexApi extends AbstractAPI {

    /**
     * 设备序列号
     */
    private String deviceSerial;
    /**
     * 通道号
     */
    private String channelNo;
    /**
     * 预置点位置1-12
     */
    private String index;
    /**
     * 请求方式
     */
    private HttpPostMethod httpMethod;

    public CallIndexApi(String accessToken, String deviceSerial, String channelNo,String index) {
        this.url = ServerConstant.CALL_INDEX;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.channelNo = channelNo;
        this.index = index;
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);
        Map<String,Object> params = new HashMap<>();
        if (accessToken != null) {
            params.put("accessToken",this.accessToken);
        }
        if(deviceSerial!=null){
            params.put("deviceSerial",this.deviceSerial);
        }
        if(channelNo!=null){
            params.put("channelNo",this.channelNo);
        }
        if(index!=null){
            params.put("index",this.index);
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
