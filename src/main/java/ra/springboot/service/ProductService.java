package ra.springboot.service;

import ra.springboot.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
    Product findById(Integer id);
    void delete(Integer id);
}
