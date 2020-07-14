package cn.sciento.fluorite.api.device.control;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.device.AddIndexVO;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加预置点
 * Api文档:http://open.ys7.com/doc/zh/book/index/device_ptz.html#device_ptz-api4
 */
public class AddIndexApi extends AbstractAPI {

    /**
     * 设备序列号
     */
    private String deviceSerial;
    /**
     * 通道号
     */
    private String channelNo;
    /**
     * 请求方式
     */
    private HttpPostMethod httpMethod;

    public AddIndexApi(String accessToken, String deviceSerial,String channelNo) {
        this.url = ServerConstant.ADD_INDEX;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.channelNo = channelNo;
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
        httpMethod.setCompleteUrl(url,params);
    }

    public BasicResponse<AddIndexVO> executeApi() {
        BasicResponse<AddIndexVO> response = null;
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
