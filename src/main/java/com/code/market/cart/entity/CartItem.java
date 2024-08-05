package com.code.market.cart.entity;

import com.code.market.base.entity.BaseEntity;
import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Entity
@SuperBuilder
public class CartItem extends BaseEntity {
    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;

}
