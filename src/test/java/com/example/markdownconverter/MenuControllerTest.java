package com.example.markdownconverter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuControllerTest {

    @Autowired
    MenuController menuController;

    @Test
    void get() {
        var responseEntityMono = menuController.get("token");
        var file = responseEntityMono.block().getBody();
        System.out.println(file);
        Assertions.assertTrue(file.contains("pub"));
    }
}

