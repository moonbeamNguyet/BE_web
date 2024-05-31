package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.OrderDetailDto;
import net.javaguides.CD_Web_backend.dto.OrdersDto;
import net.javaguides.CD_Web_backend.entity.*;
import net.javaguides.CD_Web_backend.exception.ResourceNotFoundException;
import net.javaguides.CD_Web_backend.mapper.OrdersMapper;
import net.javaguides.CD_Web_backend.repository.*;
import net.javaguides.CD_Web_backend.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private OrdersRepository ordersRepository;
    private DiscountRepository discountRepository;
    private ProvinceRepository provinceRepository;
    private DistrictsRepository districtsRepository;
    private UsersRepository usersRepository;
    private StatusOrderRepository statusOrderRepository;

    @Override
    public OrdersDto createOrder(OrdersDto ordersDto) {
        Long discountId = ordersDto.getDiscountId() != null ? ordersDto.getDiscountId().getId() : null;
        Long provinceId = ordersDto.getProvinceId().getProvinceID();
        Long districtId = ordersDto.getDistrictId().getDistrictID();
        Long userId = ordersDto.getUserId().getId();
        Long statusId = ordersDto.getStatus().getId();
        Discount discount = discountId != null ? discountRepository.findById(discountId).orElse(null) : null;
        Provinces province = provinceRepository.findById(provinceId).orElse(null);
        Districts district = districtsRepository.findById(districtId).orElse(null);
        Users user = usersRepository.findById(userId).orElse(null);
        StatusOrder status = statusOrderRepository.findById(statusId).orElse(null);
        if(province == null || district == null || user == null ){
            return null;
        }
        Orders orders = OrdersMapper.mapToOrders(ordersDto);
        orders.setDiscountId(discount);
        orders.setProvinceId(province);
        orders.setDistrictId(district);
        orders.setUserId(user);
        orders.setStatus(status);
        Orders saveOrder = ordersRepository.save(orders);

        return OrdersMapper.mapToOrdersDto(saveOrder);
    }

    @Override
    public List<OrdersDto> getOrderByIdUser(Users usersId) {
        List<Orders> orders = ordersRepository.findByUserId(usersId);
        if(orders.isEmpty()){
            throw new ResourceNotFoundException("No orders found for user with ID: " + usersId.getId());
        }
        return orders.stream()
                .map(OrdersMapper::mapToOrdersDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDto updateStatus(Long orderId, Long statusOrder) {
        Orders orders = ordersRepository.findById(orderId).orElse(null);
        StatusOrder status = statusOrderRepository.findById(statusOrder).orElse(null);
        if(orders == null && status == null){
            throw new ResourceNotFoundException("Order not found with ID: " + orderId);
        }
        orders.setStatus(status);
        Orders saveOrder = ordersRepository.save(orders);
        return OrdersMapper.mapToOrdersDto(saveOrder);
    }
}
