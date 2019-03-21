package com.itcast.domain;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 * 旅客pojo
 */
public class Traveller {
    /**
     * 无意义、主键uuid
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 证件类型 0身份证 1护照 2军官证
     */
    private Integer credentialsType;
    /**
     * 证件类型 0身份证 1护照 2军官证
     */
    private String credentialsTypeStr;
    /**
     * 证件号码
     */
    private String credentialsNum;
    /**
     * 旅客类型(人群) 0 成人 1 儿童
     */
    private Integer travellerType;
    /**
     * 旅客类型(人群) 0 成人 1 儿童
     */
    private String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    /**
     * 证件类型 0身份证 1护照 2军官证
     */
    public String getCredentialsTypeStr() {
        if (credentialsType == 0) {
            return "身份证";
        }
        if (credentialsType == 1) {
            return "护照";
        }
        if (credentialsType == 2) {
            return "军官证";
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    /**
     * 旅客类型(人群) 0 成人 1 儿童
     */
    public String getTravellerTypeStr() {
        if (travellerType == 0) {
            return "成人";
        }
        if (travellerType == 1) {
            return "儿童";
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
