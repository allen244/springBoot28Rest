package com.avs.controllers;

import com.avs.model.Question;
import com.avs.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }

    @GetMapping(value="/surveys/{surveyId}/questions/{questionId}", produces = { "application/xml","application/json" })

    public Question retrieveDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId) {

        return surveyService.retrieveQuestion(surveyId, questionId);
    }

    // /surveys/{surveyId}/questions
    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Void> addQuestionToSurvey(
            @PathVariable String surveyId, @RequestBody Question newQuestion) {

        Question question = surveyService.addQuestion(surveyId, newQuestion);

        if (question == null)
            return ResponseEntity.noContent().build();

        // Success - URI of the new resource in Response Header
        // Status - created
        // URI -> /surveys/{surveyId}/questions/{questionId}
        // question.getQuestionId()
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(question.getId()).toUri();

        // Status
        return ResponseEntity.created(location).build();
    }

//    @PostMapping("/surveys/{surveyId}/questions")
//    public ResponseEntity<Question> createNewQuestion(@PathVariable String surveyId, @RequestBody Question newQuestion) {
//        return new ResponseEntity<Question>(surveyService.addQuestion(surveyId, newQuestion), HttpStatus.CREATED);
//    }

}
