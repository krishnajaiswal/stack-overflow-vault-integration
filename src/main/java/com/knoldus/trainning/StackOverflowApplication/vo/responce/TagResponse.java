package com.knoldus.trainning.StackOverflowApplication.vo.responce;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
public class TagResponse {

    private String questionTitle;

    private String questionDescription;

    private List<String> inputAnswer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
