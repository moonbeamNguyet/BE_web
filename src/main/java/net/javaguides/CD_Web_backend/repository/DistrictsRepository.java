package net.javaguides.CD_Web_backend.repository;

import net.javaguides.CD_Web_backend.entity.Districts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictsRepository extends JpaRepository<Districts, Long> {
    List<Districts> findByProvinceID(Long provinceID);
}
