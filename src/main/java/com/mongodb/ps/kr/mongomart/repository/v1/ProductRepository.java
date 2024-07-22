package com.mongodb.ps.kr.mongomart.repository.v1;

import com.mongodb.ps.kr.mongomart.model.v1.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {

    public Product findBySku(int sku );

}
