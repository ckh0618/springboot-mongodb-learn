package com.mongodb.ps.kr.mongomart.service.v1;

import com.mongodb.ps.kr.mongomart.dto.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductViewServiceTest {

    @Autowired
    private ProductViewService service;

    @Test
    public void testGetProduct() {
        ProductResponse res = service.getProduct(1);
        System.out.println(res);
    }
}
