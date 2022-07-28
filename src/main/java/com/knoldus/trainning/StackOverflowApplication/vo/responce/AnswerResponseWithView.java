package com.knoldus.trainning.StackOverflowApplication.vo.responce;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class AnswerResponseWithView {

    private Long questionId;

    private Long totalView;

    private String inputAnswer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
