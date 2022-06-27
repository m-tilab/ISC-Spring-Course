package org.example.dao;

import java.util.List;

import javax.sql.DataSource;

import org.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

public interface ProductDao {

    @Autowired
    void setDataSource(DataSource dataSource);

    boolean create(Product product);

    Product getProduct(long productId);

    List<Product> getAllProducts();

    boolean delete(Product product);

    boolean update(Product product);

    void cleanup();
}
