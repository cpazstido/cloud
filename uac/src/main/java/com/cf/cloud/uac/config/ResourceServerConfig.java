package com.cf.cloud.uac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {
//    @Autowired
//    private CustomAccessDeniedHandler customAccessDeniedHandler;
//    @Autowired
//    private CustomHttp403ForbiddenEntryPoint customHttp403ForbiddenEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
//                .antMatchers("/oauth/*").permitAll()
                .anyRequest().authenticated()
//                .anyRequest().permitAll()
//                .and().exceptionHandling().authenticationEntryPoint(customHttp403ForbiddenEntryPoint)
//                .and().exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
        ;
    }
}
