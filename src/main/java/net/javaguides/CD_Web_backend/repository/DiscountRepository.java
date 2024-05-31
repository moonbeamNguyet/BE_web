package net.javaguides.CD_Web_backend.repository;

import net.javaguides.CD_Web_backend.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Optional<Discount> findByCode(String code);


}
