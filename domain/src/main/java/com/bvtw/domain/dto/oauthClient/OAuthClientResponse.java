package com.bvtw.domain.dto.oauthClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OAuthClientResponse {
    private String id;
    private String clientId;
    private String clientIdIssuedAt;
    private String clientName;
    private String scopes;
    private String redirectUris;
    private String partnerId;
}
