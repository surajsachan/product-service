package com.mcart.product_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Product {
    public static final String TABLE_NAME = "product-catalog"; // Table name

    private int id;
    private String title;
    private String description;
    private BigDecimal price;
    private String category;
    private String image;
    private Rating rating;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @DynamoDbAttribute("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDbAttribute("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDbAttribute("price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @DynamoDbAttribute("category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @DynamoDbAttribute("image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @DynamoDbAttribute("rating")
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}







