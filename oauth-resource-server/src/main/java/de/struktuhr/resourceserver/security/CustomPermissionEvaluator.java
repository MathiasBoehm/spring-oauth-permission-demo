package de.struktuhr.resourceserver.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

import java.io.Serializable;

public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return isAdmin(authentication);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return isAdmin(authentication);
    }

    private boolean isAdmin(Authentication authentication) {
        final Jwt jwt = (Jwt) authentication.getPrincipal();
        final String user = jwt.getSubject();
        return "ADMIN".equalsIgnoreCase(user);
    }
}
