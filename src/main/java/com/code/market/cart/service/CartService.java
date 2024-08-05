package com.code.market.cart.service;

import com.code.market.cart.entity.CartItem;
import com.code.market.cart.repository.CartRepository;
import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public void add(Product product, Member member) {
        CartItem c = CartItem.builder()
                .product(product)
                .member(member)
                .build();

        cartRepository.save(c);
    }

    public List<CartItem> getList(Member member) {
        return cartRepository.findByMember(member);
    }
}
