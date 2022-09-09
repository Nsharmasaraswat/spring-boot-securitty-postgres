package com.bezkoder.spring.security.postgresql.service;

import com.bezkoder.spring.security.postgresql.payload.request.TutorialRequest;
import com.bezkoder.spring.security.postgresql.models.TutorialResponse;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import reactor.core.publisher.Mono;

public interface TutorialService {

public Mono<TutorialResponse> createTutorial(TutorialRequest tutorialRequest,  UserDetailsImpl userDetails);

}
