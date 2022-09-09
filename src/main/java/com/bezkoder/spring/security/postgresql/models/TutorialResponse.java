package com.bezkoder.spring.security.postgresql.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialResponse {
    private String tutorialId;
    private String tutorialName;
    private String isbnNo;
    private String applicationId;
    private String createdUserId;
    private Date lastUpdatedDate;
    private Date createdDate;

}
