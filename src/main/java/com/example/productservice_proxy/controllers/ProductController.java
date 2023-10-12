package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.IProductService;
import com.example.productservice_proxy.services.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// This controller will always answer products
@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllProducts() {
        return "Getting all the products";
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) {
        Product product = this.productService.getSingleProduct(productId);
        return product;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto) {
        return "Adding new product " + productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId) {
        return "Updating product";
    }

    @PatchMapping("/{productId}")
    public String patchProduct(@PathVariable("productId") Long productId) {
        return "Patching product";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a product with id: " + productId;
    }
}