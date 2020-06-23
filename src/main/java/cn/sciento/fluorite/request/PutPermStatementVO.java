package cn.sciento.fluorite.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;
/**
 * @desc:
 * @date: 10:16 2020/6/23
 * @author: leaf
 **/
public class PutPermStatementVO {
    @JSONField(name = "Statement")
    private List<StatementBean> Statement;

    public List<StatementBean> getStatement() {
        return Statement;
    }

    public void setStatement(List<StatementBean> Statement) {
        this.Statement = Statement;
    }

    public static class StatementBean implements Serializable {
        /**
         * Permission : Get,Update,Real,Replay
         * Resource : ["dev:469631729","cam:544229080:1"]
         */
        @JSONField(name = "Permission")
        private String Permission;
        @JSONField(name = "Resource")
        private List<String> Resource;

        public String getPermission() {
            return Permission;
        }

        public void setPermission(String Permission) {
            this.Permission = Permission;
        }

        public List<String> getResource() {
            return Resource;
        }

        public void setResource(List<String> Resource) {
            this.Resource = Resource;
        }
    }
}
