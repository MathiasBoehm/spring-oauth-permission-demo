package de.struktuhr.resourceserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class OAuth2ResourceServerConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests()
                //.antMatchers("/**").hasAuthority("SCOPE_read")
                .anyRequest().authenticated()
                .and()
            .oauth2ResourceServer()
                .jwt();
        // @formatter:on
    }
}
