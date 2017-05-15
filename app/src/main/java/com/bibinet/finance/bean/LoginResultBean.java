package com.bibinet.finance.bean;

import java.io.Serializable;

/**
 * Created by bibinet on 2017-5-3.
 */

public class LoginResultBean extends ResultBean implements  Serializable{
    /**
     * returnData : {"objectId":100753,"name":"张三","type":1,"enterpriseId":100279,"account":"admin@company","cellPhone":"13241819031","officePhone":null,"email":null,"departmentId":1000724,"status":1,"firstTimeSign":1,"accountPrefix":"admin","department":{"objectId":1000724,"name":"companytest","status":1,"type":4,"parentDepartmentId":0,"enterpriseId":100279,"isDelete":0,"parent":null,"typeName":"总公司"},"isDelete":0,"identify":null,"password":null}
     */

    private ReturnDataBean returnData;

    public ReturnDataBean getReturnData() {
        return returnData;
    }

    public void setReturnData(ReturnDataBean returnData) {
        this.returnData = returnData;
    }

    public static class ReturnDataBean {
        /**
         * objectId : 100753
         * name : 张三
         * type : 1
         * enterpriseId : 100279
         * account : admin@company
         * cellPhone : 13241819031
         * officePhone : null
         * email : null
         * departmentId : 1000724
         * status : 1
         * firstTimeSign : 1
         * accountPrefix : admin
         * department : {"objectId":1000724,"name":"companytest","status":1,"type":4,"parentDepartmentId":0,"enterpriseId":100279,"isDelete":0,"parent":null,"typeName":"总公司"}
         * isDelete : 0
         * identify : null
         * password : null
         */

        private int objectId;
        private String name;
        private int type;
        private int enterpriseId;
        private String account;
        private String cellPhone;
        private Object officePhone;
        private Object email;
        private int departmentId;
        private int status;
        private int firstTimeSign;
        private String accountPrefix;
        private DepartmentBean department;
        private int isDelete;
        private Object identify;
        private Object password;

        public int getObjectId() {
            return objectId;
        }

        public void setObjectId(int objectId) {
            this.objectId = objectId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getCellPhone() {
            return cellPhone;
        }

        public void setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
        }

        public Object getOfficePhone() {
            return officePhone;
        }

        public void setOfficePhone(Object officePhone) {
            this.officePhone = officePhone;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getFirstTimeSign() {
            return firstTimeSign;
        }

        public void setFirstTimeSign(int firstTimeSign) {
            this.firstTimeSign = firstTimeSign;
        }

        public String getAccountPrefix() {
            return accountPrefix;
        }

        public void setAccountPrefix(String accountPrefix) {
            this.accountPrefix = accountPrefix;
        }

        public DepartmentBean getDepartment() {
            return department;
        }

        public void setDepartment(DepartmentBean department) {
            this.department = department;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public Object getIdentify() {
            return identify;
        }

        public void setIdentify(Object identify) {
            this.identify = identify;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public static class DepartmentBean {
            /**
             * objectId : 1000724
             * name : companytest
             * status : 1
             * type : 4
             * parentDepartmentId : 0
             * enterpriseId : 100279
             * isDelete : 0
             * parent : null
             * typeName : 总公司
             */

            private int objectId;
            private String name;
            private int status;
            private int type;
            private int parentDepartmentId;
            private int enterpriseId;
            private int isDelete;
            private Object parent;
            private String typeName;

            public int getObjectId() {
                return objectId;
            }

            public void setObjectId(int objectId) {
                this.objectId = objectId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getParentDepartmentId() {
                return parentDepartmentId;
            }

            public void setParentDepartmentId(int parentDepartmentId) {
                this.parentDepartmentId = parentDepartmentId;
            }

            public int getEnterpriseId() {
                return enterpriseId;
            }

            public void setEnterpriseId(int enterpriseId) {
                this.enterpriseId = enterpriseId;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public Object getParent() {
                return parent;
            }

            public void setParent(Object parent) {
                this.parent = parent;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }
        }
    }
}
