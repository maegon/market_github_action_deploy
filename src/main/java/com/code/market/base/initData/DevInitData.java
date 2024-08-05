package com.code.market.base.initData;

import com.code.market.member.repository.MemberRepository;
import com.code.market.member.service.MemberService;
import com.code.market.product.repository.ProductRepository;
import com.code.market.product.service.ProductService;
import com.code.market.question.repository.QuestionRepository;
import com.code.market.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("dev")
public class DevInitData implements BeforeInitData {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ProductRepository productRepository;

    @Bean
    CommandLineRunner init(MemberService memberService, QuestionService questionService, ProductService productService) {
            /*return args -> {

            for (int i = 1; i<=200; i++) {
                String name = String.format("테스트 상품 : [%03d]", i);
                String description = String.format("테스트 설명:[%03d]", i);
                // MultipartFile thumbnail =
                int price = 1;
                // productService.create(name, description, price, thumbnail);
            }
             */

        return args -> {
            beforeInit();

            String password = "1234";

            memberService.join("admin", "admin", "admin@test.com", "admin");
            memberService.join("user1", password, "user1@test.com", "user1");
            memberService.join("user2", password, "user2@test.com", "user2");
            memberService.join("user3", password, "user3@test.com", "user3");
            memberService.join("user4", password, "user4@test.com", "user4");

            productService.create("타이틀1", "1 설명입니다.", 100000);
            productService.create("타이틀2", "2 설명입니다.", 200000);
            productService.create("타이틀3", "3 설명입니다.", 300000);
            productService.create("타이틀4", "4 설명입니다.", 400000);
        };
    }
}
