package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.ImgProductDto;
import net.javaguides.CD_Web_backend.dto.ProductsDto;
import net.javaguides.CD_Web_backend.entity.Category;
import net.javaguides.CD_Web_backend.entity.ImgProduct;
import net.javaguides.CD_Web_backend.entity.Products;
import net.javaguides.CD_Web_backend.mapper.ImgProductMapper;
import net.javaguides.CD_Web_backend.mapper.ProductsMapper;
import net.javaguides.CD_Web_backend.repository.CategoryRepository;
import net.javaguides.CD_Web_backend.repository.ImgProductRepository;
import net.javaguides.CD_Web_backend.repository.ProductsRepository;
import net.javaguides.CD_Web_backend.service.ProductsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    ProductsRepository productsRepository;
    CategoryRepository categoryRepository;
    ImgProductRepository imgProductRepository;

    @Override
    public ProductsDto createProduct(ProductsDto productsDto) {
        Long categoryId = productsDto.getCategory().getId();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(category == null) {
          return null;
        }
        Products products = ProductsMapper.mapToProduct(productsDto);
        products.setCategory(category);
        Products saveProducts = productsRepository.save(products);
        return ProductsMapper.maptoProductsDto(saveProducts);
    }

    @Override
    public List<ProductsDto> getAllProducts() {
        List<Products> products = productsRepository.findAll();
        return products.stream().map((product) -> ProductsMapper.maptoProductsDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ImgProductDto createImgProduct(ImgProductDto imgProductDto) {
        Long productId = imgProductDto.getProductID().getId();
        Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ImgProduct imgProduct = ImgProductMapper.mapToImgProduct(imgProductDto);
        imgProduct.setProductID(products);
        ImgProduct saveImgProduct = imgProductRepository.save(imgProduct);
        return ImgProductMapper.mapToImgProductDto(saveImgProduct);
    }

    @Override
    public List<ImgProductDto> getAllImageByProductID(Products productID) {
        List<ImgProduct> imgProducts = imgProductRepository.findByProductID(productID);
        if(imgProducts.isEmpty()){
            throw new RuntimeException("No image found");
        }
        return imgProducts.stream().map((imgProduct) -> ImgProductMapper.mapToImgProductDto(imgProduct))
                .collect(Collectors.toList());

    }

    @Override
    public ProductsDto getProductsById(Long id) {
        Optional<Products> optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Products product = optionalProduct.get();
            return ProductsMapper.maptoProductsDto(product);
        } else {
             throw new RuntimeException("No product found");
        }
    }

    @Override
    public List<ProductsDto> getAllProductsByName(String productName) {
        List<Products> products = productsRepository.findByName(productName);
        return products.stream().map(ProductsMapper::maptoProductsDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductsDto> getAllProductsByCategory(Long idCategory) {
        List<Products> products = productsRepository.findByCategory(idCategory);
        return products.stream().map(ProductsMapper::maptoProductsDto).collect(Collectors.toList());
    }
}
