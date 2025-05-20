package com.bvtw.domain.dto.oauthClient;

import com.bvtw.domain.entity.OAuth2RegisteredClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OAuthClientCreateRequest {
    private String partnerId;
    private String clientName;
    private List<String> clientAuthenticationMethods;
    private List<String> authorizationGrantTypes;
    private List<String> redirectUris;
    private List<String> postLogoutRedirectUris;
    private List<String> scopes;
    private String clientSettings;
    private String tokenSettings;

    public OAuth2RegisteredClient oAuthRegisteredClientToEntity() {
        return new OAuth2RegisteredClient()
                .setClientId(UUID.randomUUID().toString())
                .setClientSecret(UUID.randomUUID().toString())
                .setClientName(clientName)
                .setClientAuthenticationMethods(String.join(",", clientAuthenticationMethods))
                .setAuthorizationGrantTypes(String.join(",", authorizationGrantTypes))
                .setRedirectUris(String.join(",", redirectUris))
                .setPostLogoutRedirectUris(String.join(",", postLogoutRedirectUris))
                .setScopes(String.join(",", scopes))
                .setClientSettings(clientSettings)
                .setTokenSettings(tokenSettings);
    }
}
