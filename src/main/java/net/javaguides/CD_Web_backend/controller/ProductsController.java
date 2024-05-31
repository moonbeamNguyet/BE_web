package net.javaguides.CD_Web_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.ProductsDto;
import net.javaguides.CD_Web_backend.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductsService productsService;

    @PostMapping
    public ResponseEntity<ProductsDto> createProduct(@RequestBody ProductsDto productsDto){
        ProductsDto savedProduct = productsService.createProduct(productsDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductsDto>> getAllProducts(){
        List<ProductsDto> productsDtos =productsService.getAllProducts();
        return  ResponseEntity.ok(productsDtos);
    }

    @GetMapping("{ProductId}")
    public ResponseEntity<ProductsDto> getProductsById(@PathVariable("ProductId") Long id){
        ProductsDto product =productsService.getProductsById(id);
        return  ResponseEntity.ok(product);
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductsDto>> searchProductsByName(@RequestParam String productName) {
        List<ProductsDto> products = productsService.getAllProductsByName(productName);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductsDto>> filterProductsByCategory(@PathVariable("categoryId") Long categoryId) {
        List<ProductsDto> products = productsService.getAllProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }



}


