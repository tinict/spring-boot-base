package com.bvtw.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final JwtScopeAuthorityConverter jwtScopeAuthorityConverter;

    public SecurityConfig(
            RestAuthenticationEntryPoint restAuthenticationEntryPoint,
            CustomAccessDeniedHandler customAccessDeniedHandler,
            JwtScopeAuthorityConverter jwtScopeAuthorityConverter) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
        this.jwtScopeAuthorityConverter = jwtScopeAuthorityConverter;
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtScopeAuthorityConverter);
        return jwtAuthenticationConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/login",
                                "/cp/login",
                                "/forgot",
                                "/logout",
                                "/forget-password",
                                "/update-password/*",
                                "/error/*",
                                "/temp/*"
                        ).permitAll()
                        .requestMatchers(
                                "/v1/access_token",
                                "/custom/authorize",
                                "/oauth2/v1/**"
                        ).permitAll()
                        .requestMatchers(
                                "/api/v1/partners",
                                "/api/v1/partners/*/**",
                                "/api/v1/oauth2-client-registers",
                                "/api/v1/tasks",
                                "/api/v1/tasks/*/**"
                        ).permitAll()
                        .requestMatchers(
                                "/api/v1/test/hello"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(restAuthenticationEntryPoint)
                        .accessDeniedHandler(customAccessDeniedHandler)
                )
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
                                .jwkSetUri("http://127.0.0.1:5000/oauth2/jwks")
                        )
                );

        http.cors(withDefaults());

        http.csrf(csrf -> csrf
                .ignoringRequestMatchers(
                        new AntPathRequestMatcher("/v1/access_token"),
                        new AntPathRequestMatcher("/custom/authorize"),
                        new AntPathRequestMatcher("/oauth2/v1/**"),
                        new AntPathRequestMatcher("/api/v1/tasks"),
                        new AntPathRequestMatcher("/api/v1/tasks/**"),
                        new AntPathRequestMatcher("/api/v1/partners"),
                        new AntPathRequestMatcher("/api/v1/partners/**"),
                        new AntPathRequestMatcher("/api/v1/oauth2-client-registers")
                ));

        return http.build();
    }
}
