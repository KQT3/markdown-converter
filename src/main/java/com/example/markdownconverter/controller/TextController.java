package com.example.markdownconverter.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("texts")
@AllArgsConstructor
@CrossOrigin("*")
public class TextController {

    @GetMapping(value = "pub/{name}", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public Mono<ResponseEntity<String>> pub(@RequestHeader("Authorization") String token, @PathVariable("name") String name) {
        try {
            InputStream fileFromResourceAsStream = FileHelper.getFileFromResourceAsStream("pub/" + name.toLowerCase() + ".md");
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
