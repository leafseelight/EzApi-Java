package cn.sciento.fluorite.response.device;

import java.io.Serializable;
import java.util.List;

/**
 * @desc:
 * @date:11:30 2020/7/14
 * @author:leaf
 **/
public class DeviceCapacityVO implements Serializable{

    /**
     * support_cloud : 1
     * support_intelligent_track : 1
     * support_p2p_mode : 1
     * support_resolution : 16-9
     * support_talk : 1
     * video_quality_capacity : [{"streamType":"1","videoLevel":"0","resolution":"1","videoBitRate":"5","maxBitRate":"0"},{"streamType":"1","videoLevel":"1","resolution":"3","videoBitRate":"9","maxBitRate":"0"},{"streamType":"1","videoLevel":"2","resolution":"19","videoBitRate":"13","maxBitRate":"0"}]
     * support_wifi_userId : 1
     * support_remote_auth_randcode : 1
     * support_upgrade : 1
     * support_smart_wifi : 1
     * support_ssl : 1
     * support_weixin : 1
     * ptz_close_scene : 1
     * support_preset_alarm : 1
     * support_related_device : 0
     * support_message : 0
     * ptz_preset : 1
     * support_wifi : 3
     * support_cloud_version : 1
     * ptz_center_mirror : 1
     * support_defence : 1
     * ptz_top_bottom : 1
     * support_fullscreen_ptz : 1
     * support_defenceplan : 1
     * support_disk : 1
     * support_alarm_voice : 1
     * ptz_left_right : 1
     * support_modify_pwd : 1
     * support_capture : 1
     * support_privacy : 1
     * support_encrypt : 1
     * support_auto_offline : 1
     */

    private String support_cloud;
    private String support_intelligent_track;
    private String support_p2p_mode;
    private String support_resolution;
    private String support_talk;
    private String support_wifi_userId;
    private String support_remote_auth_randcode;
    private String support_upgrade;
    private String support_smart_wifi;
    private String support_ssl;
    private String support_weixin;
    private String ptz_close_scene;
    private String support_preset_alarm;
    private String support_related_device;
    private String support_message;
    private String ptz_preset;
    private String support_wifi;
    private String support_cloud_version;
    private String ptz_center_mirror;
    private String support_defence;
    private String ptz_top_bottom;
    private String support_fullscreen_ptz;
    private String support_defenceplan;
    private String support_disk;
    private String support_alarm_voice;
    private String ptz_left_right;
    private String support_modify_pwd;
    private String support_capture;
    private String support_privacy;
    private String support_encrypt;
    private String support_auto_offline;
    private List<VideoQualityCapacityBean> video_quality_capacity;

    public String getSupport_cloud() {
        return support_cloud;
    }

    public void setSupport_cloud(String support_cloud) {
        this.support_cloud = support_cloud;
    }

    public String getSupport_intelligent_track() {
        return support_intelligent_track;
    }

    public void setSupport_intelligent_track(String support_intelligent_track) {
        this.support_intelligent_track = support_intelligent_track;
    }

    public String getSupport_p2p_mode() {
        return support_p2p_mode;
    }

    public void setSupport_p2p_mode(String support_p2p_mode) {
        this.support_p2p_mode = support_p2p_mode;
    }

    public String getSupport_resolution() {
        return support_resolution;
    }

    public void setSupport_resolution(String support_resolution) {
        this.support_resolution = support_resolution;
    }

    public String getSupport_talk() {
        return support_talk;
    }

    public void setSupport_talk(String support_talk) {
        this.support_talk = support_talk;
    }

    public String getSupport_wifi_userId() {
        return support_wifi_userId;
    }

    public void setSupport_wifi_userId(String support_wifi_userId) {
        this.support_wifi_userId = support_wifi_userId;
    }

    public String getSupport_remote_auth_randcode() {
        return support_remote_auth_randcode;
    }

    public void setSupport_remote_auth_randcode(String support_remote_auth_randcode) {
        this.support_remote_auth_randcode = support_remote_auth_randcode;
    }

    public String getSupport_upgrade() {
        return support_upgrade;
    }

    public void setSupport_upgrade(String support_upgrade) {
        this.support_upgrade = support_upgrade;
    }

    public String getSupport_smart_wifi() {
        return support_smart_wifi;
    }

    public void setSupport_smart_wifi(String support_smart_wifi) {
        this.support_smart_wifi = support_smart_wifi;
    }

    public String getSupport_ssl() {
        return support_ssl;
    }

    public void setSupport_ssl(String support_ssl) {
        this.support_ssl = support_ssl;
    }

    public String getSupport_weixin() {
        return support_weixin;
    }

    public void setSupport_weixin(String support_weixin) {
        this.support_weixin = support_weixin;
    }

    public String getPtz_close_scene() {
        return ptz_close_scene;
    }

    public void setPtz_close_scene(String ptz_close_scene) {
        this.ptz_close_scene = ptz_close_scene;
    }

    public String getSupport_preset_alarm() {
        return support_preset_alarm;
    }

    public void setSupport_preset_alarm(String support_preset_alarm) {
        this.support_preset_alarm = support_preset_alarm;
    }

    public String getSupport_related_device() {
        return support_related_device;
    }

    public void setSupport_related_device(String support_related_device) {
        this.support_related_device = support_related_device;
    }

    public String getSupport_message() {
        return support_message;
    }

    public void setSupport_message(String support_message) {
        this.support_message = support_message;
    }

    public String getPtz_preset() {
        return ptz_preset;
    }

    public void setPtz_preset(String ptz_preset) {
        this.ptz_preset = ptz_preset;
    }

    public String getSupport_wifi() {
        return support_wifi;
    }

    public void setSupport_wifi(String support_wifi) {
        this.support_wifi = support_wifi;
    }

    public String getSupport_cloud_version() {
        return support_cloud_version;
    }

    public void setSupport_cloud_version(String support_cloud_version) {
        this.support_cloud_version = support_cloud_version;
    }

    public String getPtz_center_mirror() {
        return ptz_center_mirror;
    }

    public void setPtz_center_mirror(String ptz_center_mirror) {
        this.ptz_center_mirror = ptz_center_mirror;
    }

    public String getSupport_defence() {
        return support_defence;
    }

    public void setSupport_defence(String support_defence) {
        this.support_defence = support_defence;
    }

    public String getPtz_top_bottom() {
        return ptz_top_bottom;
    }

    public void setPtz_top_bottom(String ptz_top_bottom) {
        this.ptz_top_bottom = ptz_top_bottom;
    }

    public String getSupport_fullscreen_ptz() {
        return support_fullscreen_ptz;
    }

    public void setSupport_fullscreen_ptz(String support_fullscreen_ptz) {
        this.support_fullscreen_ptz = support_fullscreen_ptz;
    }

    public String getSupport_defenceplan() {
        return support_defenceplan;
    }

    public void setSupport_defenceplan(String support_defenceplan) {
        this.support_defenceplan = support_defenceplan;
    }

    public String getSupport_disk() {
        return support_disk;
    }

    public void setSupport_disk(String support_disk) {
        this.support_disk = support_disk;
    }

    public String getSupport_alarm_voice() {
        return support_alarm_voice;
    }

    public void setSupport_alarm_voice(String support_alarm_voice) {
        this.support_alarm_voice = support_alarm_voice;
    }

    public String getPtz_left_right() {
        return ptz_left_right;
    }

    public void setPtz_left_right(String ptz_left_right) {
        this.ptz_left_right = ptz_left_right;
    }

    public String getSupport_modify_pwd() {
        return support_modify_pwd;
    }

    public void setSupport_modify_pwd(String support_modify_pwd) {
        this.support_modify_pwd = support_modify_pwd;
    }

    public String getSupport_capture() {
        return support_capture;
    }

    public void setSupport_capture(String support_capture) {
        this.support_capture = support_capture;
    }

    public String getSupport_privacy() {
        return support_privacy;
    }

    public void setSupport_privacy(String support_privacy) {
        this.support_privacy = support_privacy;
    }

    public String getSupport_encrypt() {
        return support_encrypt;
    }

    public void setSupport_encrypt(String support_encrypt) {
        this.support_encrypt = support_encrypt;
    }

    public String getSupport_auto_offline() {
        return support_auto_offline;
    }

    public void setSupport_auto_offline(String support_auto_offline) {
        this.support_auto_offline = support_auto_offline;
    }

    public List<VideoQualityCapacityBean> getVideo_quality_capacity() {
        return video_quality_capacity;
    }

    public void setVideo_quality_capacity(List<VideoQualityCapacityBean> video_quality_capacity) {
        this.video_quality_capacity = video_quality_capacity;
    }

    public static class VideoQualityCapacityBean implements Serializable {
        /**
         * streamType : 1
         * videoLevel : 0
         * resolution : 1
         * videoBitRate : 5
         * maxBitRate : 0
         */

        private String streamType;
        private String videoLevel;
        private String resolution;
        private String videoBitRate;
        private String maxBitRate;

        public String getStreamType() {
            return streamType;
        }

        public void setStreamType(String streamType) {
            this.streamType = streamType;
        }

        public String getVideoLevel() {
            return videoLevel;
        }

        public void setVideoLevel(String videoLevel) {
            this.videoLevel = videoLevel;
        }

        public String getResolution() {
            return resolution;
        }

        public void setResolution(String resolution) {
            this.resolution = resolution;
        }

        public String getVideoBitRate() {
            return videoBitRate;
        }

        public void setVideoBitRate(String videoBitRate) {
            this.videoBitRate = videoBitRate;
        }

        public String getMaxBitRate() {
            return maxBitRate;
        }

        public void setMaxBitRate(String maxBitRate) {
            this.maxBitRate = maxBitRate;
        }
    }
}
