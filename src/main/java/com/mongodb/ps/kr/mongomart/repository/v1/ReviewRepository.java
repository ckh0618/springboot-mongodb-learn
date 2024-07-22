package com.mongodb.ps.kr.mongomart.repository.v1;

import com.mongodb.ps.kr.mongomart.model.v1.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

    public List<Review> findBySkuOrderByDateDesc(int sku );
}
