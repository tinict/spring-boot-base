package com.bvtw.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class JwtScopeAuthorityConverter implements org.springframework.core.convert.converter.Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<String> scopes = jwt.getClaimAsStringList("scope");
        System.out.println("Scopes: " + scopes);

        if (!CollectionUtils.isEmpty(scopes)) {
            for (String scope : scopes) {
                authorities.add(new SimpleGrantedAuthority(scope));
            }
        }

        return authorities;
    }
}
