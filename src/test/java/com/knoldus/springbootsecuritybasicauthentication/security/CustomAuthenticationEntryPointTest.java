package com.knoldus.springbootsecuritybasicauthentication.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomAuthenticationEntryPoint.class})
@ExtendWith(SpringExtension.class)
class CustomAuthenticationEntryPointTest {
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    /**
     * Method under test: {@link CustomAuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCommence() throws IOException {
        // TODO: Complete this test.
        //  /home/knoldus/blank/spring-boot-security-basic-authentication/test.txt
        //  Please ensure that temporary files are deleted in the method under test.

        // Arrange
        // TODO: Populate arranged inputs
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AuthenticationException authEx = null;

        // Act
        this.customAuthenticationEntryPoint.commence(request, response, authEx);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link CustomAuthenticationEntryPoint#afterPropertiesSet()}
     */
    @Test
    void testAfterPropertiesSet() {
        this.customAuthenticationEntryPoint.afterPropertiesSet();
        assertEquals("MyRealm", this.customAuthenticationEntryPoint.getRealmName());
    }
}

