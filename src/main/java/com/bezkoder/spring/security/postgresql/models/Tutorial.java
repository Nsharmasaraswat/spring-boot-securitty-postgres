package com.bezkoder.spring.security.postgresql.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "tutorials")
@AttributeOverride(name = "applicationId", column = @Column(name = "appl_ext_id"))
public class Tutorial extends ApplicationBaseModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "tutorial_id")
    private UUID tutorialId;

    @Column(name = "tutorial_Name", nullable = false)
    private String tutorialName;

    @Column(name = "isbn_no", nullable = false)
    private String isbnNo;


}
