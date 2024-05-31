package net.javaguides.CD_Web_backend.repository;

import net.javaguides.CD_Web_backend.entity.ImgProduct;
import net.javaguides.CD_Web_backend.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImgProductRepository extends JpaRepository<ImgProduct, Long> {

    List<ImgProduct> findByProductID(Products productID);
}
