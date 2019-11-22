package com.canhazip.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@SpringBootApplication
public class Application {

    private final String url = "https://canhazip.com";

    @GetMapping("/")
    public String index() throws Exception{
        return queryIp();
    }

    private String queryIp() throws Exception{
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder(
                        new URI(url)).GET().build(),
                        HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}




