package com.cf.cloud.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jjmendoza on 14/7/2017.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().permitAll()
                .and()
                .logout().logoutSuccessUrl("http://www.baidu.com")
                .and()
//                .requestMatchers()
//                .antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access", "/exit")
//                .and()
                .authorizeRequests()
                .antMatchers("/webjars/**","/logout","/login").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
        ;
    }
}
