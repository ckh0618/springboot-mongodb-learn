package com.mongodb.ps.kr.mongomart.model.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
@AllArgsConstructor
public class Customer {
    @Indexed(unique = true)
    int userId;
    String hashedPassword ;
    String name;
    Date registeation;
}
