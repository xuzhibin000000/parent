package com.mj.sms.com.mj.sms.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author xuzhibin
 */
@Entity
@Table(name = "good_infos")
public class GoodInfoBean implements Serializable
{

    /**
     * 主键ID
     */
     @Id
     @Column(name = "tg_id")
     @GeneratedValue
     private Long id;

    /**
     * 标题
     */
    @Column(name = "tg_title")
    private String title;

    /**
     * 价格
     */
    @Column(name = "tg_price")
    private double price;

    /**
     * 单位
     */
    @Column(name = "tg_unit")
    private String unit;

    /**
     * 排序
     */
    @Column(name = "tg_order")
    private int order;

    /**
     * 类型编号
     */
    @Column(name = "tg_type_id")
    private Long typeId;


}
