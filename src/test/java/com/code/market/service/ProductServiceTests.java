package com.code.market.service;

import com.code.market.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
public class ProductServiceTests {
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("강의 제품 생성")
    void test1() {
        for(int i = 1; i <= 200; i++) {
            String name = String.format("테스트 상품 : [%03d]", i);
            String description = String.format("테스트 설명:[%03d]", i);
            // MultipartFile thumbnail =
            int price = 1;
            // productService.create(name, description, price, thumbnail);
        }
    }
}
