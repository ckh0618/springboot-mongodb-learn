package com.mongodb.ps.kr.mongomart.model.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Review {

    @Indexed(unique = true)
    private int reviewId ;
    private Date date;
    private String comment;

    private int userId ;
    private int sku;

}
