package com.mongodb.ps.kr.mongomart.repository.v1;

import com.mongodb.ps.kr.mongomart.model.v1.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

    public Customer findByUserId ( int userId );
}
