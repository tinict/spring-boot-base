package com.bvtw.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        // Get the access token from the OAuth2AuthorizedClient
//        String accessToken = authorizedClient.getAccessToken().getTokenValue();

        return "Hello, test. Access Token: ";
    }

}
