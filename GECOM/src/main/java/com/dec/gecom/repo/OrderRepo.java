package com.dec.gecom.repo;

import com.dec.gecom.constant.StatusConstant;
import com.dec.gecom.entity.EOrder;
import com.dec.gecom.entity.Product;
import org.hibernate.query.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<EOrder,Long> {

        List<EOrder> findByOrderStatus(StatusConstant statusConstant);

        List<EOrder> findAll();
    List<EOrder> findEOrderByOrderDate(Date orderDate);

    }

