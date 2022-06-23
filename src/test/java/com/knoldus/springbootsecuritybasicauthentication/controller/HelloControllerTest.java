package com.knoldus.springbootsecuritybasicauthentication.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {HelloController.class})
@ExtendWith(SpringExtension.class)
class HelloControllerTest {
    @Autowired
    private HelloController helloController;

    /**
     * Method under test: {@link HelloController#HelloAdmin()}
     */
    @Test
    void testHelloAdmin() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin");
        MockMvcBuilders.standaloneSetup(this.helloController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello Admin!"));
    }

    /**
     * Method under test: {@link HelloController#HelloAdmin()}
     */
    @Test
    void testHelloAdmin2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.helloController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello Admin!"));
    }

    /**
     * Method under test: {@link HelloController#HelloPrivate()}
     */
    @Test
    void testHelloPrivate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/private");
        MockMvcBuilders.standaloneSetup(this.helloController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello Private!"));
    }

    /**
     * Method under test: {@link HelloController#HelloPrivate()}
     */
    @Test
    void testHelloPrivate2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/private");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.helloController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello Private!"));
    }

    /**
     * Method under test: {@link HelloController#HelloPublic()}
     */
    @Test
    void testHelloPublic() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/public");
        MockMvcBuilders.standaloneSetup(this.helloController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello Public!"));
    }

    /**
     * Method under test: {@link HelloController#HelloPublic()}
     */
    @Test
    void testHelloPublic2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/public");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.helloController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Hello Public!"));
    }
}

