package com.code.market.question.controller;

import com.code.market.member.entity.Member;
import com.code.market.member.service.MemberService;
import com.code.market.product.entity.Product;
import com.code.market.product.service.ProductService;
import com.code.market.question.entity.Question;
import com.code.market.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final ProductService productService;
    private final MemberService memberService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id, Principal principal, @RequestParam("content") String content) {
        Product product = productService.getProduct(id);
        Member member = memberService.findByUserName(principal.getName());

        questionService.create(product, member, content);

        return "redirect:/product/detail/" + id;
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Model model, Principal principal) {
        Question question = questionService.getQuestion(id);

        // 로그인은 됐는데 작성자 주인이 아니면 못하게 막기
        if(question.getMember().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
        }

        model.addAttribute("question", question);
        return "question/modify";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        Question question = questionService.getQuestion(id);
        questionService.delete(question);
        long productId = question.getProduct().getId();

        // 로그인은 됐는데 작성자 주인이 아니면 못하게 막기
        if(question.getMember().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
        }


        return "redirect:/product/detail/" + productId;
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Principal principal, @RequestParam("content") String content) {
        Question question = questionService.getQuestion(id);
            questionService.modify(question, content);
            long productId = question.getProduct().getId();

        return "redirect:/product/detail/" + productId;
    }
}
