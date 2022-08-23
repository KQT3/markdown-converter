package com.example.markdownconverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ServerApplicationTests {

	@Autowired TextController textController;

	@Test
	void test() {
		String main = textController.pub("token", "MAIN").block().getBody();
		System.out.println(main);
		assertTrue(main.contains("Sensera Intranet"));
	}

}
