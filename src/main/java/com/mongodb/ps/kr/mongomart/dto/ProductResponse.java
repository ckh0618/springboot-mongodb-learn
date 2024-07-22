package com.mongodb.ps.kr.mongomart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class ProductResponse {

    private int sku;
    private String name;
    private String description;
    private List<String> tag;
    private double price;
    private short stars;
    private String imagePath;

    private List<ReviewResponse> reviews;

    public void addReviews(List<ReviewResponse> reviewResponses) {
        reviews = reviewResponses;
    }

    public ProductResponse()  {

    }
}
