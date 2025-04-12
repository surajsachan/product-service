package com.mcart.product_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
@Configuration
public class DynamoDBConfig {
    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("AKIAYSE4NXCBI4OJWG5T", "B2YDPYOP/IyQKv47SD2qwnTxgnf7TAdZEsa2vqNK")
//                        AwsBasicCredentials.create("your-access-key", "your-secret-key")
                ))
                .build();
    }
}