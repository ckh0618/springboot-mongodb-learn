package com.mongodb.ps.kr.mongomart.service.v1;

import com.mongodb.ps.kr.mongomart.model.v1.Customer;
import com.mongodb.ps.kr.mongomart.model.v1.Product;
import com.mongodb.ps.kr.mongomart.model.v1.Review;
import com.mongodb.ps.kr.mongomart.repository.v1.CustomerRepository;
import com.mongodb.ps.kr.mongomart.repository.v1.ProductRepository;
import com.mongodb.ps.kr.mongomart.repository.v1.ReviewRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DataGeneraterService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CustomerRepository userRepository;


    public int generate(int scale) {

        productRepository.deleteAll();
        reviewRepository.deleteAll();
        userRepository.deleteAll();


        Faker faker = new Faker(new Locale("en"));
        List<Product> products = new ArrayList<>();


        // n 개의 Product 생성

        for (int i = 0; i < scale; i++) {
            Product prod = new Product(
                    i,
                    faker.commerce().productName(),
                    faker.lorem().sentence(),
                    faker.lorem().words(),
                    (long) Double.parseDouble(faker.commerce().price(10, 1000)) * 100,
                    (short) faker.number().numberBetween(0, 5),
                    faker.file().fileName()
            );

            products.add(prod);
        }
        List<Product> results = productRepository.saveAll(products);

        if (results.size() != scale) {
            throw new RuntimeException("Product 생성 실패");
        }


        // n 명의 Customer 생성
        List<Customer> users = new ArrayList<>();
        for (int i = 0; i < scale; i++) {
            Customer user = new Customer (
                    i,
                    faker.hashing().md5(),
                    faker.name().fullName(),
                    faker.date().birthday()
            );
            users.add(user);
        }

        List<Customer> customerResult = userRepository.saveAll(users);
        if (customerResult.size() != scale) {
            throw new RuntimeException("Customer 생성 실패");
        }

        // n*100 의 review 생성
        List<Review> reviews = new ArrayList<>();
        for (int i = 0; i < scale * 100 ; i++) {
            Review review = new Review (
                    i,
                    faker.date().birthday(),
                    faker.lorem().sentence(),
                    faker.number().numberBetween(0, scale),
                    faker.number().numberBetween(0, scale)
                    );
            reviews.add(review);
        }

        List<Review> reviewResult = reviewRepository.saveAll(reviews);

        if (reviewResult.size() != scale * 100) {
            throw new RuntimeException("Review 생성 실패");
        }
        return scale;
    }

}
