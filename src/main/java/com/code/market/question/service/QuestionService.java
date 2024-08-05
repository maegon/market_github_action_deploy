package com.code.market.question.service;

import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import com.code.market.question.entity.Question;
import com.code.market.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public void create(Product product, Member member, String content) {
        Question question = Question.builder()
                .member(member)
                .product(product)
                .content(content)
                .build();

        questionRepository.save(question);
    }

    public Question getQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        } else {
            throw new RuntimeException("question not found");
        }
    }

    public void modify(Question question, String content) {
        Question modifyQuestion = question.toBuilder()
                .content(content)
                .build();

        questionRepository.save(question);
    }

    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
