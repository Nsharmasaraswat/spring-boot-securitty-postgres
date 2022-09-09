package com.bezkoder.spring.security.postgresql.repository;


import com.bezkoder.spring.security.postgresql.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, UUID> {

    public Optional<Tutorial> findByIsbnNo(String isbnNo);

}
