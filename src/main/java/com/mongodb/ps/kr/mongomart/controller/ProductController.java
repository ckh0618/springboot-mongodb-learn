package com.mongodb.ps.kr.mongomart.controller;

import com.mongodb.ps.kr.mongomart.dto.ProductResponse;
import com.mongodb.ps.kr.mongomart.service.v1.DataGeneraterService;
import com.mongodb.ps.kr.mongomart.service.v1.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductViewService service;

    @Autowired
    private DataGeneraterService dataGenService;

    @GetMapping("/product/{sku}")
    public ProductResponse getProduct(@PathVariable int sku) {
        return service.getProduct(sku);
    }

    @GetMapping("/generate/{scale}")
    public int generateData(@PathVariable int scale) {
        return dataGenService.generate(scale);
    }

}
