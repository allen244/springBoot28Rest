package com.avs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestNydnCLient {

    public int postJsonContent(String endpoint) {

        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/surveys/Survey1/questions");
            StringBuilder builder = new StringBuilder();


            builder.append("{id:");
            builder.append(":");
            builder.append("Question1");
            builder.append(",");
            builder.append("description");
            builder.append(":");
            builder.append("Largest Country in the World");
            builder.append(",");
            builder.append("correctAnswer");
            builder.append(":");
            builder.append("Russia");
            builder.append(",");
            builder.append("options");
            builder.append(":");
            builder.append("[");
            builder.append("India");
            builder.append(",");
            builder.append("Russia");
            builder.append(",");
            builder.append("United States");
            builder.append(",");
            builder.append("\"China\"");
            builder.append("]");
            builder.append("}");

String test= builder.toString();
            String jsonInput = "{\"custmer\":\"Java2novice\",\"address\":\"Bangalore\","+
                    "\"bill-amount\":\"$2000\"}";
          //String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonInput);

            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);
            return response.getStatus();
        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;
    }

    public static void main(String[] args) {
        TestNydnCLient cLient= new TestNydnCLient();
      int code=  cLient.postJsonContent("");

        System.out.println(code);
    }
}
