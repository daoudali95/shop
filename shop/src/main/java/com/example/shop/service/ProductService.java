package com.example.shop.service;

import com.example.shop.dao.Product;
import com.example.shop.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){return productRepository.save(product);}

    public Optional<Product> findProduct(Integer id){return productRepository.findById(id);}

    public List<Product> getAllProducts(){return productRepository.findAll();}

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
