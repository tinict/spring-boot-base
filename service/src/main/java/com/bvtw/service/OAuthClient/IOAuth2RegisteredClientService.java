package com.bvtw.service.OAuthClient;

import com.bvtw.domain.dto.oauthClient.OAuthClientCreateRequest;
import com.bvtw.domain.entity.OAuth2RegisteredClient;
import com.bvtw.service.IGeneralService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

public interface IOAuth2RegisteredClientService extends IGeneralService<OAuth2RegisteredClient, String> {
//    OAuth2RegisteredClient save(OAuth2RegisteredClient oAuth2RegisteredClient, String partnerId);
    RegisteredClient createClient(OAuth2RegisteredClient oauth2RegisteredClient);
}
