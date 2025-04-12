package com.mcart.product_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Rating {
    private double rate;
    private int count;

    @DynamoDbAttribute("rate")
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @DynamoDbAttribute("count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
