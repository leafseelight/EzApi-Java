package cn.sciento.fluorite.api.device.manage;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.request.RequestInfo;
import cn.sciento.fluorite.response.BaseDeviceResponse;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * NVR设备删除IPC
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 12:32 PM
 */
public class NvcDeleteIpc extends AbstractAPI{
    private String deviceSerial;
    private String ipcSerial;
    private HttpPostMethod httpPostMethod;

    public NvcDeleteIpc(String url, String accessToken, String deviceSerial,String ipcSerial,Integer channelNo) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.ipcSerial = ipcSerial;
        this.method = RequestInfo.Method.POST;
        this.host = ServerConstant.HOST;
        this.contentType = "application/x-www-form-urlencoded";

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,null);
        bodyMap.put("ipcSerial",ipcSerial);
        if (channelNo != null) {
            bodyMap.put("channelNo",channelNo);
        }
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<BaseDeviceResponse> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            httpPostMethod.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
