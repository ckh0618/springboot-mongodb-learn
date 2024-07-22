package com.mongodb.ps.kr.mongomart.model.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@Getter
@Setter
@AllArgsConstructor
public class Product {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private int sku;

    private String name;
    private String description;
    private List<String> tag;
    private double price;
    private short stars;
    private String imagePath;

    public Product() {

    }

    public Product( int sku, String name, String description, List<String> tag, long price, short stars, String imagePath) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.price = price;
        this.stars = stars;
        this.imagePath = imagePath;
    }

}

