package com.itcast.domain;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 * 会员表
 */
public class Member {
    /**
     *无意义、主键uuid
     */
    private String id;
    /**
     *姓名
     */
    private String name;
    /**
     *昵称
     */
    private String nickname;
    /**
     *电话号码
     */
    private String phoneNum;
    /**
     *邮箱
     */
    private String email;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
