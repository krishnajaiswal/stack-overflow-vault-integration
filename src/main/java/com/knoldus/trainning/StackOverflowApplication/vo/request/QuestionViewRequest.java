package com.knoldus.trainning.StackOverflowApplication.vo.request;

import lombok.Data;

@Data
public class QuestionViewRequest {

    private String questionTitle;

    private String questionDescription;

    private String tagName;

}
