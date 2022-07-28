package com.knoldus.trainning.StackOverflowApplication.vo.responce;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class QuestionResponeWithView {

    private Long id;

    private Long totalNumberOfViews;

    private String questionTitle;

    private String questionDescription;

    private String tagName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
