package com.joshua.cj.pojo;


import java.io.Serializable;
import java.util.Date;

public class OrderList implements Serializable {

    private Long id;
    private String orderNumber;
    private String goodsName;
    private String goodsType;
    private Double quantity;
    private String measureUnit;
    private Date createData;
    private Date releaseDate;
    private Date stockOutDate;
    private Boolean isStock;
    private Boolean isStockOut;
    private Long stockInUserId;
    private Long stockOutUserId;
    private Double singlePrice;
    private Double sumPrice;
    private String orderFrom;
    private String orderTo;
    private String comments;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", quantity=" + quantity +
                ", measureUnit='" + measureUnit + '\'' +
                ", createData=" + createData +
                ", releaseDate=" + releaseDate +
                ", stockOutDate=" + stockOutDate +
                ", isStock=" + isStock +
                ", isStockOut=" + isStockOut +
                ", stockInUserId=" + stockInUserId +
                ", stockOutUserId=" + stockOutUserId +
                ", singlePrice=" + singlePrice +
                ", sumPrice=" + sumPrice +
                ", orderFrom='" + orderFrom + '\'' +
                ", orderTo='" + orderTo + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
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

    public Boolean getStock() {
        return isStock;
    }

    public void setStock(Boolean stock) {
        isStock = stock;
    }

    public Boolean getStockOut() {
        return isStockOut;
    }

    public void setStockOut(Boolean stockOut) {
        isStockOut = stockOut;
    }

    public Long getStockInUserId() {
        return stockInUserId;
    }

    public void setStockInUserId(Long stockInUserId) {
        this.stockInUserId = stockInUserId;
    }

    public Long getStockOutUserId() {
        return stockOutUserId;
    }

    public void setStockOutUserId(Long stockOutUserId) {
        this.stockOutUserId = stockOutUserId;
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
}
