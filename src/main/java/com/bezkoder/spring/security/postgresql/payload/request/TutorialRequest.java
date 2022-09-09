package com.bezkoder.spring.security.postgresql.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialRequest {

    @JsonProperty("tutorial_Name")
    @NotBlank
    private String tutorialName;

    @JsonProperty("isbn_no")
    @NotBlank
    private String isbn_no;

}
