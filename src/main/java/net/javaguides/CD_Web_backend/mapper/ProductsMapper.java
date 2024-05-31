package net.javaguides.CD_Web_backend.mapper;

import net.javaguides.CD_Web_backend.dto.ProductsDto;
import net.javaguides.CD_Web_backend.entity.Products;

public class ProductsMapper {
    public static ProductsDto maptoProductsDto(Products products){
        return new ProductsDto(
                products.getId(),
                products.getProductName(),
                products.getDetail(),
                products.getPrice(),
                products.getPercentDiscount(),
                products.getQuantity(),
                products.getCategory(),
                products.getCreateDate(),
                products.getStatus()

        );
    }

    public static Products mapToProduct(ProductsDto productsDto){
        return new Products(
                productsDto.getId(),
                productsDto.getProductName(),
                productsDto.getDetail(),
                productsDto.getPrice(),
                productsDto.getPercentDiscount(),
                productsDto.getQuantity(),
                productsDto.getCategory(),

                productsDto.getCreateDate(),
                productsDto.getStatus()
        );
    }
}
