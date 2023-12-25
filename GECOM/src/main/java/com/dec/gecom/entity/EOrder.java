package com.dec.gecom.entity;


import com.dec.gecom.constant.StatusConstant;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "e_order")
@Data
public class EOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
    @CreationTimestamp
    private Instant createdOn;


    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private StatusConstant orderStatus;

    @Temporal(TemporalType.DATE)
//    @Column(name="order_date")
    private Date orderDate;

}
