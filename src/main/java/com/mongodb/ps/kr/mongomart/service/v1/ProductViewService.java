package com.mongodb.ps.kr.mongomart.service.v1;

import com.mongodb.ps.kr.mongomart.dto.ProductResponse;
import com.mongodb.ps.kr.mongomart.dto.ReviewResponse;
import com.mongodb.ps.kr.mongomart.model.v1.Customer;
import com.mongodb.ps.kr.mongomart.model.v1.Product;
import com.mongodb.ps.kr.mongomart.model.v1.Review;
import com.mongodb.ps.kr.mongomart.repository.v1.CustomerRepository;
import com.mongodb.ps.kr.mongomart.repository.v1.ProductRepository;
import com.mongodb.ps.kr.mongomart.repository.v1.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductViewService {

    @Autowired
    private ProductRepository productRepo ;

    @Autowired
    private ReviewRepository reviewRepo ;


    @Autowired
    private CustomerRepository customerRepo ;


    public ProductResponse getProduct(int sku ) {

        ProductResponse response = new ProductResponse();

        Product product = productRepo.findBySku(sku);
        if (product == null) {
            return null;
        }

        response.setSku(product.getSku());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setImagePath(product.getImagePath());
        response.setPrice(product.getPrice());
        response.setTag(product.getTag());


        List<Review> reviews = reviewRepo.findBySkuOrderByDateDesc(sku);
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for (Review review : reviews) {
            ReviewResponse reviewResponse = new ReviewResponse();
            reviewResponse.setComment(review.getComment());
            reviewResponse.setDate(review.getDate());

            Customer customer = customerRepo.findByUserId(review.getUserId());
            reviewResponse.setUserName(customer.getName());
            reviewResponses.add(reviewResponse);
        }

        response.addReviews(reviewResponses);
        return response;
    }






}
