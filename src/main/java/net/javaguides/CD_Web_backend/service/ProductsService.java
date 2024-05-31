package net.javaguides.CD_Web_backend.service;

import net.javaguides.CD_Web_backend.dto.ImgProductDto;
import net.javaguides.CD_Web_backend.dto.ProductsDto;
import net.javaguides.CD_Web_backend.entity.Products;

import java.util.List;

public interface ProductsService {

    ProductsDto createProduct(ProductsDto productsDto);
    List<ProductsDto> getAllProducts();

    //imgProduct
    ImgProductDto createImgProduct(ImgProductDto imgProductDto);
    List<ImgProductDto> getAllImageByProductID(Products productID);

    ProductsDto getProductsById(Long id);

    List<ProductsDto> getAllProductsByName(String productName);

    List<ProductsDto> getAllProductsByCategory(Long idCategory);
}
