package com.code.market.answer.entity;

import com.code.market.base.entity.BaseEntity;
import com.code.market.question.entity.Question;
import com.code.market.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Answer extends BaseEntity {
    private String comment;

    @OneToOne
    private Member member;

    @OneToOne
    private Question question;
}
