package com.bezkoder.spring.security.postgresql.service;

import com.bezkoder.spring.security.postgresql.exception.DuplicateEntityException;
import com.bezkoder.spring.security.postgresql.models.Tutorial;
import com.bezkoder.spring.security.postgresql.payload.request.TutorialRequest;
import com.bezkoder.spring.security.postgresql.models.TutorialResponse;
import com.bezkoder.spring.security.postgresql.repository.TutorialRepositoryManagement;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    TutorialRepositoryManagement tutorialRepositoryManagement;

    @Override
    public Mono<TutorialResponse> createTutorial(TutorialRequest tutorialRequest, UserDetailsImpl userDetails) {

        Optional<Tutorial> tutorialOptional = tutorialRepositoryManagement.findByIsbnNo(tutorialRequest.getIsbn_no().trim());
        if (tutorialOptional.isPresent()) {
            return Mono.error(new DuplicateEntityException(tutorialRequest.getIsbn_no().trim()));
        }
        Tutorial tutorial = Tutorial.builder().tutorialName(tutorialRequest.getTutorialName()).isbnNo(tutorialRequest.getIsbn_no().trim()).build();
        tutorial.populateCreatedFields(userDetails);
       // tutorial.populateUpdatedFields(userDetails);
        Tutorial tutorial1 = tutorialRepositoryManagement.createTutorial(tutorial);
        TutorialResponse tutorialResponse = new ModelMapper().map(tutorial1, TutorialResponse.class);
        return Mono.just(tutorialResponse);
    }
}
