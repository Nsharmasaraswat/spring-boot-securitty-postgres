package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.Tutorial;

import java.util.Optional;

public interface TutorialRepositoryManagement {


    public Tutorial createTutorial(Tutorial tutorial);

    public Optional<Tutorial> findByIsbnNo(String isbnno);

}
