package com.avs.client;

import com.avs.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestfulClient {
    RestTemplate restTemplate;

    @Autowired
    public RestfulClient() {
        restTemplate = new RestTemplate();
    }

    public void getEntity() {
        System.out.println("Begin /GET request!");
        String getUrl = "http://localhost:8080/surveys/Survey1/questions/Question1";
        ResponseEntity<Question> getResponse = restTemplate.getForEntity(getUrl, Question.class);
        if (getResponse.getBody() != null) {
            System.out.println("Response for Get Request: " + getResponse.getBody().toString());
        } else {
            System.out.println("Response for Get Request: NULL");
        }
    }

    public void postEntity(Question question) {
        System.out.println("Begin /POST request!");
        // replace http://localhost:8080 by your restful services
        String postUrl = "http://localhost:8080/surveys/Survey1/questions";

        ResponseEntity<Question> postResponse = restTemplate.postForEntity(postUrl, question, Question.class);
        System.out.println("Response for Post Request: " + postResponse.getBody());
    }


    public static void main(String[] args) {
        RestfulClient client = new RestfulClient();
     //   client.getEntity();

        Question q = new Question("Question100",
                "test", "United States", Arrays.asList(
                "India", "Russia", "United States", "China"));

        client.postEntity(q);
    }

}