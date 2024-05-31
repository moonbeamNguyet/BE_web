package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.OrderDetailDto;
import net.javaguides.CD_Web_backend.dto.ProductsDto;
import net.javaguides.CD_Web_backend.entity.OrderDetail;
import net.javaguides.CD_Web_backend.entity.Orders;
import net.javaguides.CD_Web_backend.entity.Products;
import net.javaguides.CD_Web_backend.entity.StatusOrder;
import net.javaguides.CD_Web_backend.mapper.OrderDetailMapper;
import net.javaguides.CD_Web_backend.mapper.OrdersMapper;
import net.javaguides.CD_Web_backend.mapper.ProductsMapper;
import net.javaguides.CD_Web_backend.repository.OrderDetailRepository;
import net.javaguides.CD_Web_backend.repository.OrdersRepository;
import net.javaguides.CD_Web_backend.repository.ProductsRepository;
import net.javaguides.CD_Web_backend.repository.StatusOrderRepository;
import net.javaguides.CD_Web_backend.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    private OrdersRepository ordersRepository;
    private ProductsRepository productsRepository;
    private StatusOrderRepository statusOrderRepository;
    @Override
    public OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto) {
        Long orderId = orderDetailDto.getOrderId().getId();
        Long productId = orderDetailDto.getProductId().getId();
        Orders orders = ordersRepository.findById(orderId).orElse(null);
        Products products = productsRepository.findById(productId).orElse(null);
        if (orders == null || products == null) {
            return null;
        }
        OrderDetail orderDetail = OrderDetailMapper.mapToOrderDetai(orderDetailDto);
        orderDetail.setOrderId(orders);
        orderDetail.setProductId(products);
        OrderDetail saveOrderDetail = orderDetailRepository.save(orderDetail);
        updateProductQuantity(productId, orderDetailDto.getQuantity());
        return OrderDetailMapper.mapToOrderDetailDto(saveOrderDetail);
    }

    @Override
    public List<OrderDetailDto> getAllOrderId(Long userId, Orders orderId) {
        // Kiểm tra xem userId có khớp với id trên param không
        if (!isUserIdMatchesOrder(userId, orderId)) {
            throw new IllegalArgumentException("User ID does not match the order ID");
        }
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);
        if (orderDetails.isEmpty()) {
            return null;
        }
        return orderDetails.stream()
                .map(OrderDetailMapper::mapToOrderDetailDto)
                .collect(Collectors.toList());
    }



    private boolean isUserIdMatchesOrder(Long userId, Orders orderId) {
        // Lấy userId từ orderId
        Long orderUserId = orderId.getUserId().getId();
        // So sánh userId với userId từ orderId
        return userId.equals(orderUserId);
    }


    public ProductsDto updateProductQuantity(Long productId, long quantity) {
        Products product = productsRepository.findById(productId).orElse(null);
        product.setQuantity(product.getQuantity()- quantity);
        Products updatedProduct = productsRepository.save(product);
        return ProductsMapper.maptoProductsDto(updatedProduct);

    }
}
