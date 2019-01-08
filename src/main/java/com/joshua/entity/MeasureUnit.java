package com.joshua.entity;

import javax.persistence.*;

/**
 * Created by joshua on 2018-04-16.
 */
@Entity
@SequenceGenerator(name = "measureUnit",sequenceName = "measureUnit_sequence",initialValue = 1,allocationSize = 1)
public class MeasureUnit {

//    @Id
    private Integer id;

    private String unit;

    private String des;

    public MeasureUnit(Integer id, String unit, String des) {
        this.id = id;
        this.unit = unit;
        this.des = des;
    }

    public MeasureUnit() {
    }

    @Id
    @Column(name="id")
    @GeneratedValue(generator="measureUnit")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "MeasureUnit{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
