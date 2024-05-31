package net.javaguides.CD_Web_backend.repository;

import net.javaguides.CD_Web_backend.entity.OrderDetail;
import net.javaguides.CD_Web_backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderId(Orders OrderId);
}
