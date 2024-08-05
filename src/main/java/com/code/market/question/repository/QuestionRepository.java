package com.code.market.question.repository;

import com.code.market.member.entity.Member;
import com.code.market.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
