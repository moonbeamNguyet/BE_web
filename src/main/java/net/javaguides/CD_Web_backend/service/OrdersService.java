package net.javaguides.CD_Web_backend.service;

import net.javaguides.CD_Web_backend.dto.OrderDetailDto;
import net.javaguides.CD_Web_backend.dto.OrdersDto;
import net.javaguides.CD_Web_backend.entity.StatusOrder;
import net.javaguides.CD_Web_backend.entity.Users;

import java.util.List;

public interface OrdersService {
    OrdersDto createOrder(OrdersDto ordersDto);
    List<OrdersDto> getOrderByIdUser(Users usersId);
    OrdersDto updateStatus(Long orderId, Long statusOrder);

}
