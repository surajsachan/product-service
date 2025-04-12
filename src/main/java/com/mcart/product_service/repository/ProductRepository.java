package com.mcart.product_service.repository;

import com.mcart.product_service.entity.Product;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final DynamoDbTable<Product> productTable;
    public ProductRepository(DynamoDbClient dynamoDbClient) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
        productTable = enhancedClient.table(Product.TABLE_NAME, TableSchema.fromBean(Product.class));
    }
    public void save(Product product) {
        productTable.putItem(product);
    }
    public Product findById(String productId) {
        return productTable.getItem(r -> r.key(k -> k.partitionValue(productId)));
    }
    public void delete(String productId) {
        productTable.deleteItem(r -> r.key(k -> k.partitionValue(productId)));
    }
    public List<Product> findAll() {
        return productTable.scan().items().stream().collect(Collectors.toList());
    }
}
