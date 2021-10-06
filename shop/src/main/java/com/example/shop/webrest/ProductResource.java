package com.example.shop.webrest;

import com.example.shop.dao.Product;
import com.example.shop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public ResponseEntity<Product> creatMember(@RequestBody Product product){
        Product productRes = productService.create(product);
        return ResponseEntity.ok().body(productRes);
    }

    @GetMapping("Allproducts")
    public ResponseEntity<List<Product>>AllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findProduct(@PathVariable int id){
        return productService.findProduct(id);
    }

    @DeleteMapping("/delProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Product deleted id : "+ id);
    }
}
