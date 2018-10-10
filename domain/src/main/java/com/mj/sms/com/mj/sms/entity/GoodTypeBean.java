package com.mj.sms.com.mj.sms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author xuzhibin
 */
@Entity
@Table(name = "good_types")
public class GoodTypeBean implements Serializable {

    /**
     * 主键Id
     */
    @Id
    @GeneratedValue
    @Column(name = "tgt_id")
    private long id;

    /**
     * 类型名称
     */
    @Column(name = "tgt_name")
    private String name;

    /**
     * 是否显示
     */
    @Column(name = "tgt_is_show")
    private int is_show;

    /**
     * 排序
     */
    @Column(name = "tgt_order")
    private int order;

}
