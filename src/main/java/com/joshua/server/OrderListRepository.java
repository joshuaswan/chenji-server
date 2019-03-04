package com.joshua.server;

import com.joshua.entity.GoodsName;
import com.joshua.entity.GoodsType;
import com.joshua.entity.OrderList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by joshua on 2018-04-17.
 */
public interface OrderListRepository extends CrudRepository<OrderList,Long> {
    OrderList findById(Integer id);

    @Override
    Optional<OrderList> findById(Long aLong);

    @Override
    @Query("select o from OrderList o order by o.id desc ")
    Iterable<OrderList> findAll();

    @Query("select o from OrderList o where o.isStock =1 order by o.id desc")
    List<OrderList> getStockIn();

    @Query("select o from OrderList o where o.isStock =2 order by o.stockOutDate desc")
    List<OrderList> getStockOut();

    @Modifying
    @Query("select o from OrderList o where o.orderNumber = :orderNumber")
    List<OrderList> findByOrderNumber(@Param("orderNumber") String orderNumber);

    @Modifying
    @Query("select o from OrderList o where o.orderNumber = :orderNumber and o.isStock = 1")
    List<OrderList> findByStockOutOrderNumber(@Param("orderNumber") String orderNumber);

    @Query("select o from OrderList o where o.isStock=0 order by o.id desc")
    List<OrderList> unPrint();
}
