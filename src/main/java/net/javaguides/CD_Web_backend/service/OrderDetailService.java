package net.javaguides.CD_Web_backend.service;

import net.javaguides.CD_Web_backend.dto.OrderDetailDto;
import net.javaguides.CD_Web_backend.entity.Orders;
import net.javaguides.CD_Web_backend.entity.StatusOrder;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto);
    List<OrderDetailDto> getAllOrderId(Long userId, Orders orderId);


}
