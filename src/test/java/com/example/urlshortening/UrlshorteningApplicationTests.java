package com.example.urlshortening;

import com.example.urlshortening.service.UrlServiceShortenerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UrlshorteningApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlServiceShortenerService service;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public MockMvc mockMvc(WebApplicationContext webApplicationContext) {
            return MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }
    }

    @BeforeEach
    public void setup() {
        when(service.encode("https://example.com")).thenReturn("http://short.est/abc123");
        when(service.decode("http://short.est/abc123")).thenReturn("https://example.com");
    }

    @Test
    public void testEncodeEndpoint() throws Exception {
        mockMvc.perform(post("/encode").param("url", "https://example.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("http://short.est/abc123"));
    }

    @Test
    public void testDecodeEndpoint() throws Exception {
        mockMvc.perform(get("/decode").param("shortUrl", "http://short.est/abc123"))
                .andExpect(status().isOk())
                .andExpect(content().string("https://example.com"));
    }

}
