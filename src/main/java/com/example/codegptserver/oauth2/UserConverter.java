package com.example.codegptserver.oauth2;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        Authentication authentication = super.extractAuthentication(map);
        PrincipalUser principalUser = new PrincipalUser((String) map.get("employeeId"), (String) map.get("displayName"), (String) map.get("email"));
        List<GrantedAuthority> authorities = authentication.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getAuthority())).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(principalUser, authentication.getCredentials(), authorities);
    }

}
