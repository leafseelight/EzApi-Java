package cn.sciento.fluorite.response.account;

import java.io.Serializable;
import java.util.List;

public class AccountInfoResponse implements Serializable {


    /**
     * accountId : b3ad7ba927524b748e557572024d4ac2
     * accountName : test
     * appKey : ae1b9af9dcac4caeb88da6dbbf2dd8d5
     * accountStatus : 1
     * policy : {"Statement":[{"Permission":"GET,UPDATE,REAL","Resource":["dev:469631729","dev:519928976","cam:544229080:1"]},{"Permission":"GET","Resource":["dev:470686804"]}]}
     */

    private String accountId;
    private String accountName;
    private String appKey;
    private int accountStatus;
    private PolicyBean policy;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public PolicyBean getPolicy() {
        return policy;
    }

    public void setPolicy(PolicyBean policy) {
        this.policy = policy;
    }

    public static class PolicyBean implements Serializable {
        private List<StatementBean> Statement;

        public List<StatementBean> getStatement() {
            return Statement;
        }

        public void setStatement(List<StatementBean> Statement) {
            this.Statement = Statement;
        }

        public static class StatementBean implements Serializable {
            /**
             * Permission : GET,UPDATE,REAL
             * Resource : ["dev:469631729","dev:519928976","cam:544229080:1"]
             */

            private String Permission;
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
}
