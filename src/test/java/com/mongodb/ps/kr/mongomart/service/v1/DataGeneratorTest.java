package com.mongodb.ps.kr.mongomart.service.v1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataGeneratorTest {
    @Autowired
    DataGeneraterService service;

    @Test
    public void testGenerate( ) {
        Assertions.assertDoesNotThrow(() -> {
            service.generate(10);
        });
    }
}
