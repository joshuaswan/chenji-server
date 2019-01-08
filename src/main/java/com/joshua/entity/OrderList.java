package com.joshua.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by joshua on 2018-04-16.
 */

@Entity
@SequenceGenerator(name = "orderList",sequenceName = "orderList_sequence",initialValue = 1,allocationSize = 1)
public class OrderList {

    @Id
    @Column(name="id")
    @GeneratedValue(generator="orderList")
    private Integer id;

    private String orderNumber;

    @ManyToOne
    private GoodsName goodsName;
    @ManyToOne
    private GoodsType goodsType;

    private Double quantity;
    @ManyToOne
    private MeasureUnit measureUnit;

    private Date createDate;

    private Date releaseDate;

    private Date stockOutDate;

    /**
     * isStock = 1 代表已入库
     * isStock = 2 代表已出库
     */
    private Integer isStock;
    @ManyToOne
    private UserInfo stockInUser;
    @ManyToOne
    private UserInfo stockOutUser;

    private String goodsGo;

    private Double singlePrice;

    private Double sumPrice;

    private String orderFrom;

    private String orderTo;

    private String comments;

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getOrderTo() {
        return orderTo;
    }

    public void setOrderTo(String orderTo) {
        this.orderTo = orderTo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public OrderList() {
    }

    public OrderList(String orderNumber, GoodsName goodsName, GoodsType goodsType, Double quantity, MeasureUnit measureUnit,
                     Date createDate, Date releaseDate, Date stockOutDate, Integer isStock, UserInfo stockInUser, UserInfo stockOutUser,
                     String goodsGo, Double singlePrice, Double sumPrice, String orderFrom, String orderTo, String comments) {
        this.orderNumber = orderNumber;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
        this.createDate = createDate;
        this.releaseDate = releaseDate;
        this.stockOutDate = stockOutDate;
        this.isStock = isStock;
        this.stockInUser = stockInUser;
        this.stockOutUser = stockOutUser;
        this.goodsGo = goodsGo;
        this.singlePrice = singlePrice;
        this.sumPrice = sumPrice;
        this.orderFrom = orderFrom;
        this.orderTo = orderTo;
        this.comments = comments;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoodsName getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(GoodsName goodsName) {
        this.goodsName = goodsName;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getStockOutDate() {
        return stockOutDate;
    }

    public void setStockOutDate(Date stockOutDate) {
        this.stockOutDate = stockOutDate;
    }

    public Integer getIsStock() {
        return isStock;
    }

    public void setIsStock(Integer isStock) {
        this.isStock = isStock;
    }

    public UserInfo getStockInUser() {
        return stockInUser;
    }

    public void setStockInUser(UserInfo stockInUser) {
        this.stockInUser = stockInUser;
    }

    public UserInfo getStockOutUser() {
        return stockOutUser;
    }

    public void setStockOutUser(UserInfo stockOutUser) {
        this.stockOutUser = stockOutUser;
    }

    public String getGoodsGo() {
        return goodsGo;
    }

    public void setGoodsGo(String goodsGo) {
        this.goodsGo = goodsGo;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", goodsName=" + goodsName +
                ", goodsType=" + goodsType +
                ", quantity=" + quantity +
                ", measureUnit=" + measureUnit +
                ", createDate=" + createDate +
                ", releaseDate=" + releaseDate +
                ", stockOutDate=" + stockOutDate +
                ", isStock=" + isStock +
                ", stockInUser=" + stockInUser +
                ", stockOutUser=" + stockOutUser +
                ", goodsGo='" + goodsGo + '\'' +
                ", singlePrice=" + singlePrice +
                ", sumPrice=" + sumPrice +
                '}';
    }

    public void stockIn(){
        isStock = 1;
    }

    public void saveOrder(){
        isStock = 0;
    }

    public void stockOut(){
        isStock = 2;
    }
}
