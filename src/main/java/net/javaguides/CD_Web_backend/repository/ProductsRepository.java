package net.javaguides.CD_Web_backend.repository;

import net.javaguides.CD_Web_backend.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query("SELECT p FROM Products p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :productName, '%'))")
    List<Products> findByName(@Param("productName") String productName);
    @Query("SELECT p FROM Products p WHERE p.category.id = :id")
    List<Products> findByCategory(@Param("id") Long id);
}
