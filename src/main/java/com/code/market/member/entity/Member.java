package com.code.market.member.entity;

import com.code.market.base.entity.BaseEntity;
import com.code.market.cart.entity.CartItem;
import com.code.market.cash.entity.CashLog;
import com.code.market.product.entity.Product;
import com.code.market.question.entity.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String isActive;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<CartItem> cartList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<CashLog> cashList;
}
