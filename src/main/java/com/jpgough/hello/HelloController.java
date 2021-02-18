package com.jpgough.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private RestTemplate restTemplate = new RestTemplate();
    private String WORLD_URL = "http://world/message";
    private String WORLD_RANDOM_URL = "http://world/message/random";


    @GetMapping("/hello")
    public Response simpleHelloRequest() {
        return new Response("Hello");
    }

    @GetMapping("/hello/message")
    public Response helloWorldRequest() {
        Response response = restTemplate.getForObject(WORLD_URL, Response.class);
        return new Response("Hello " + response.getMessage());
    }

    @GetMapping("/hello/message/random")
    public Response helloWorldRandomRequest() {
        Response response = restTemplate.getForObject(WORLD_RANDOM_URL, Response.class);
        return new Response("Hello " + response.getMessage());
    }

    @GetMapping("/hello/message/random/double")
    public Response helloWorldRandomDoubleRequest() {
        Response response1 = restTemplate.getForObject(WORLD_RANDOM_URL, Response.class);
        Response response2 = restTemplate.getForObject(WORLD_RANDOM_URL, Response.class);
        return new Response("Hello " + response1.getMessage() + " and " + response2.getMessage());
    }
}
