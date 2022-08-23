package com.example.markdownconverter.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("menus")
@AllArgsConstructor
@CrossOrigin("*")
public class MenuController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<String>> get(@RequestHeader("Authorization") String token) {
        try {
            InputStream fileFromResourceAsStream = FileHelper.getFileFromResourceAsStream("menu.json");
            String data = new String(fileFromResourceAsStream.readAllBytes());
            return Mono.just(data)
                    .map(ResponseEntity::ok);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return Mono.just(ResponseEntity.badRequest().build());
        } catch (IOException e) {
            e.printStackTrace();
            return Mono.just(ResponseEntity.badRequest().build());
        }
    }
}
