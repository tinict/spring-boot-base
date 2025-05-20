package com.bvtw.api;

import com.bvtw.domain.dto.oauthClient.OAuthClientCreateRequest;
import com.bvtw.domain.entity.OAuth2RegisteredClient;
import com.bvtw.service.OAuthClient.OAuth2RegisteredClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/oauth2-client-registers")
@AllArgsConstructor
public class OAuth2ClientRegisteredClientController {
    private OAuth2RegisteredClientService oauth2RegisteredClientService;

    @PostMapping
    public ResponseEntity<?> registerAppClient(@RequestBody OAuthClientCreateRequest oauthClientCreateRequest) {
        try {
            OAuth2RegisteredClient oauth2RegisteredClientRequest = oauthClientCreateRequest.oAuthRegisteredClientToEntity();

            RegisteredClient registerAppClient = oauth2RegisteredClientService.createClient(oauth2RegisteredClientRequest);

            return ResponseEntity.ok(registerAppClient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register client");
        }
    }
}
