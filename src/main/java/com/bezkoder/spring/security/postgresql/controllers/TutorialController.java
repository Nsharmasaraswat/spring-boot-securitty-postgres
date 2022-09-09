package com.bezkoder.spring.security.postgresql.controllers;


import com.bezkoder.spring.security.postgresql.payload.request.TutorialRequest;
import com.bezkoder.spring.security.postgresql.models.TutorialResponse;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import com.bezkoder.spring.security.postgresql.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping("/tutorial")
@RestController
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') OR hasRole('MODERATOR')")
    public Mono<ResponseEntity<TutorialResponse>> creteTutorial(@RequestBody @Valid TutorialRequest tutorialRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return tutorialService.createTutorial(tutorialRequest,userDetails).flatMap(tutorialResponse ->
                Mono.just(new ResponseEntity<>(tutorialResponse, HttpStatus.CREATED)));
    }


}
