package com.code.market.rebate.entity;

import com.code.market.base.entity.BaseEntity;
import com.code.market.order.entity.Order;
import com.code.market.order.entity.OrderItem;
import com.code.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RebateOrderItem extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Order order;

    @ManyToOne(fetch = LAZY)
    private OrderItem orderItem;

    @ManyToOne(fetch = LAZY)
    private Product product;

    private int price; // 판매가
    private int payPrice; // 결제금액
    private boolean isPaid; // 결제여부
    private LocalDateTime payDate;

}
