package net.javaguides.CD_Web_backend.repository;

import net.javaguides.CD_Web_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
