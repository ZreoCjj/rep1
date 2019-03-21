package com.itcast.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 * 订单表
 */
public class Orders {
    /**
     * 无意义、主键uuid
     */
    private String id;

    /**
     * 订单编号 不为空 唯一
     */
    private String orderNum;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 下单时间字符串格式
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String orderTimeStr;
    /**
     * 订单状态(0 未支付 1 已支付)
     */
    private int orderStatus;
    /**
     * 订单状态(0 未支付 1 已支付)字符串
     */
    private String orderStatusStr;
    /**
     * 订单描述(其它信息)
     */
    private String orderDesc;
    /**
     * 出行人数
     */
    private int peopleCount;
    /**
     * 支付方式(0 支付宝 1 微信 2其它)
     */
    private Integer payType;
    /**
     * 支付方式(0 支付宝 1 微信 2其它)字符串
     */
    private String payTypeStr;
    /**
     * 产品对象
     */
    private Product product;
    /**
     * 旅客信息集合
     */
    private List<Traveller> travellers;
    /**
     *会员对象
     */
    private Member member;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime!=null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(orderTime);
        }
        return orderTimeStr;
    }
    /**
     * 订单状态(0 未支付 1 已支付)
     */
    public String getOrderStatusStr() {
        if (orderStatus==0){
            return "未支付";
        }if (orderStatus==1){
            return "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    /**
     * 支付方式(0 支付宝 1 微信 2其它)字符串
     */
    public String getPayTypeStr() {
        if (payType==0){
            return "支付宝";
        }if (payType==1){
            return "微信";
        }if (payType==2){
            return "其它";
        }
        return payTypeStr;
    }
    public Product getProduct() {
        return product;
    }


    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List <Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List <Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", peopleCount=" + peopleCount +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                '}';
    }
}
