package com.joshua.entity;

import javax.persistence.*;

/**
 * Created by joshua on 2018-04-16.
 */
@Entity
@SequenceGenerator(name = "goodsType",sequenceName = "goodsType_sequence",initialValue = 1,allocationSize = 1)
public class GoodsType {

    @Id
    private Integer id;

    private String name;

    private String des;

    public GoodsType(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public GoodsType() {
    }

    @Id
    @Column(name="id")
    @GeneratedValue(generator="goodsType")//写明使用哪个序列生成器
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "GoodsTypeRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
