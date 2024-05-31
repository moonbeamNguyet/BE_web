package net.javaguides.CD_Web_backend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.ImgProductDto;
import net.javaguides.CD_Web_backend.entity.Products;
import net.javaguides.CD_Web_backend.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/imgProducts")
public class ImgProductController {
    private final ProductsService productsService;

    @PostMapping
    public ResponseEntity<ImgProductDto> createImgProduct(@RequestBody ImgProductDto imgProductDto){
        ImgProductDto saveImgProduct = productsService.createImgProduct(imgProductDto);
        return new ResponseEntity<>(saveImgProduct, HttpStatus.CREATED);
    }

    @GetMapping("{productID}")
    public ResponseEntity<List<ImgProductDto>> getAllImageByProductID(@PathVariable("productID") Products productID){
        List<ImgProductDto> imgProductDtos = productsService.getAllImageByProductID(productID);
        return  ResponseEntity.ok(imgProductDtos);
    }
}
