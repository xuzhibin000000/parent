package com.mj.sms.com.mj.sms.com.mj.sms.controller;

import com.mj.sms.com.mj.sms.dto.GoodDto;
import com.mj.sms.com.mj.sms.entity.QGoodInfoBean;
import com.mj.sms.com.mj.sms.entity.QGoodTypeBean;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author xuzhibin
 */
@RestController
public class GoodController {

    /**
     * 实体管理
     */
    @Autowired
    private EntityManager entityManager;

    private JPAQueryFactory queryFactory;

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @RequestMapping("/hello")
    public String hello(){

        return "hello world";
    }

    /**
     * 根据QueryDSL查询
     * *
     * @return
     ***/
    @RequestMapping(value = "/select")
    public List<GoodDto> selectWithQueryDSL() {
        //商品基本信息
        QGoodInfoBean _Q_good = QGoodInfoBean.goodInfoBean;
        //商品类型
        QGoodTypeBean _Q_good_type = QGoodTypeBean.goodTypeBean;
        System.out.print("start");
        List<GoodDto> list =  queryFactory .select( Projections.bean(
                GoodDto.class,
                _Q_good.id,
                _Q_good.price,
                _Q_good.title,
                _Q_good.unit,
                _Q_good_type.name.as("typeName"),
                _Q_good_type.id.as("typeId")
                 )
        ) .from(_Q_good,_Q_good_type)
          .where(_Q_good.typeId.eq(_Q_good_type.id))
          .orderBy(_Q_good.order.desc())
          .fetch();
        System.out.print(list.size());
        return list;
    }

}
