package com.example.surveyserver.oauth2;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        Authentication authentication = super.extractAuthentication(map);
        PrincipalUser principalUser = new PrincipalUser((String) map.get("employeeId"), (String) map.get("displayName"), (String) map.get("email"));
        return new UsernamePasswordAuthenticationToken(principalUser, authentication.getCredentials(), authentication.getAuthorities());
    }

}
