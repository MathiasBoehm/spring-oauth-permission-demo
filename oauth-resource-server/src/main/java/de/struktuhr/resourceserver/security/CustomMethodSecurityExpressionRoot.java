package de.struktuhr.resourceserver.security;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

import de.struktuhr.resourceserver.control.UserInfoService;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private Object filterObject;

    private Object returnObject;

    private UserInfoService userInfoService;

    public CustomMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean isMemberOfOrganization(String organizationId) {
        final Jwt jwt = (Jwt) this.getPrincipal();
        final String user = jwt.getSubject();

        final String userOrganization = userInfoService.getOrganizationId(user);

        return organizationId.equals(userOrganization);
    }

    public boolean isAdmin() {
        final Jwt jwt = (Jwt) this.getPrincipal();
        final String user = jwt.getSubject();
        return "ADMIN".equalsIgnoreCase(user);
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public Object getFilterObject() {
        return this.filterObject;
    }

    @Override
    public Object getReturnObject() {
        return this.returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }

    @Override
    public void setFilterObject(Object obj) {
        this.filterObject = obj;
    }

    @Override
    public void setReturnObject(Object obj) {
        this.returnObject = obj;
    }

}
