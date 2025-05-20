package com.bvtw.utils;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OAuthClientUtils {
    public static Set<ClientAuthenticationMethod> parseClientAuthenticationMethods(String methods) {
        return Arrays.stream(methods.split(","))
                .map(String::trim)
                .map(ClientAuthenticationMethod::new)
                .collect(Collectors.toSet());
    }

    public static Set<AuthorizationGrantType> parseAuthorizationGrantTypes(String grantTypes) {
        return Arrays.stream(grantTypes.split(","))
                .map(String::trim)
                .map(AuthorizationGrantType::new)
                .collect(Collectors.toSet());
    }

    public static Set<String> parseScopes(String scopes) {
        return Arrays.stream(scopes.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }
}
