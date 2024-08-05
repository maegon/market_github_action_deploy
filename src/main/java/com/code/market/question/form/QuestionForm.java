package com.code.market.question.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="내용을 작성해주세요.")
    @Size(max=1000, message = "내용을 1000자 이내로 입력해주세요.")
    private String content;
}