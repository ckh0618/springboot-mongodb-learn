package com.mongodb.ps.kr.mongomart.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReviewResponse {
    private Date date;
    private String comment;

    private String userName;
}
