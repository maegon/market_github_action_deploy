package com.code.market.question.entity;

import com.code.market.base.entity.BaseEntity;
import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class Question extends BaseEntity {
    private String content;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;
}
