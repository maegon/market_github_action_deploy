package com.code.market.cash.entity;

import com.code.market.base.entity.BaseEntity;
import com.code.market.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CashLog extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member member;
    private long price;
}
