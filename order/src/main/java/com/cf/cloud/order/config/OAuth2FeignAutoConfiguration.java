package com.cf.cloud.order.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import java.util.Arrays;

@Configuration
public class OAuth2FeignAutoConfiguration {

    @Autowired
    private OAuth2ClientContext oauth2Context;

    @Bean
    public OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri("http://localhost:9000/oauth/token");
        resourceDetails.setClientId("app1");
        resourceDetails.setClientSecret("123456");
        resourceDetails.setGrantType("client_credentials");
        resourceDetails.setAuthenticationScheme(AuthenticationScheme.valueOf("header"));
        resourceDetails.setScope(Arrays.asList("*"));

        return resourceDetails;
    }

    @Bean
    public OAuth2ClientContext oauth2ClientContext() {
        DefaultOAuth2ClientContext defaultOAuth2ClientContext = new DefaultOAuth2ClientContext();
        return defaultOAuth2ClientContext;
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails) {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(oAuth2ProtectedResourceDetails, oauth2Context);
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        restTemplate.setRequestFactory(factory);
        return restTemplate;
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
        return new OAuth2FeignRequestInterceptor(oAuth2RestTemplate);
    }
}
