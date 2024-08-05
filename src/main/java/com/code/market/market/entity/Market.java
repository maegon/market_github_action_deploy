package com.code.market.market.entity;

import com.code.market.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Market extends BaseEntity {
    private String email;
    private String name;
    private String info;
}