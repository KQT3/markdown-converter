package com.example.markdownconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MarkdownConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkdownConverterApplication.class, args);
    }

    @Bean
    WebClient.Builder webClient() {
        return WebClient.builder();
    }
}
