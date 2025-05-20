package com.bvtw.service.OAuthClient;

import com.bvtw.domain.entity.OAuth2RegisteredClient;
import com.bvtw.utils.OAuthClientUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import com.bvtw.repositories.IOAuth2RegisteredClientRepository;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OAuth2RegisteredClientService implements IOAuth2RegisteredClientService {
    private final IOAuth2RegisteredClientRepository oAuth2RegisteredClientRepository;
    private final JdbcRegisteredClientRepository registeredClientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<OAuth2RegisteredClient> findAll() {
        return List.of();
    }

    @Override
    public Optional<OAuth2RegisteredClient> findById(String id) {
        return Optional.empty();
    }

    @Override
    public OAuth2RegisteredClient save(OAuth2RegisteredClient oauth2RegisteredClient) {
        return oAuth2RegisteredClientRepository.save(oauth2RegisteredClient);
    }

    @Override
    public void delete(OAuth2RegisteredClient oAuth2RegisteredClient) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public RegisteredClient createClient(OAuth2RegisteredClient registeredClient) {
        String rawClientId = UUID.randomUUID().toString();
        String rawClientSecret = UUID.randomUUID().toString();
        System.out.println("rawClientId: " + rawClientId);
        System.out.println("rawClientSecret: " + rawClientSecret);

        RegisteredClient.Builder clientBuilder = RegisteredClient
                .withId(registeredClient.getClientName())
                .clientId(rawClientId)
                .clientSecret(passwordEncoder.encode(rawClientSecret))
                .clientAuthenticationMethods(s -> {
                    s.add(ClientAuthenticationMethod.CLIENT_SECRET_POST);
                    s.add(ClientAuthenticationMethod.CLIENT_SECRET_BASIC);
                })
                .redirectUri("http://localhost:8080/login/oauth2/code/")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .authorizationGrantType(AuthorizationGrantType.JWT_BEARER)
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(true)
                        .requireProofKey(false)
                        .build())
                .tokenSettings(TokenSettings.builder()
                        .accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
                        .idTokenSignatureAlgorithm(SignatureAlgorithm.RS256)
                        .accessTokenTimeToLive(Duration.ofMinutes(30))
                        .refreshTokenTimeToLive(Duration.ofHours(60 * 60))
                        .reuseRefreshTokens(true)
                        .build());

        OAuthClientUtils.parseScopes(registeredClient.getScopes())
                .forEach(clientBuilder::scope);

        RegisteredClient client = clientBuilder.build();

        registeredClientRepository.save(client);
        return client;

    }
}
