package net.javaguides.CD_Web_backend.mapper;

import net.javaguides.CD_Web_backend.dto.OrderDetailDto;
import net.javaguides.CD_Web_backend.entity.OrderDetail;

public class OrderDetailMapper {
    public  static OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetai){
        return  new OrderDetailDto(
                orderDetai.getOrderDetailId(),
                orderDetai.getOrderId(),
                orderDetai.getProductId(),
                orderDetai.getPrice(),
                orderDetai.getQuantity(),
                orderDetai.getTotal()
        );
    }

    public static OrderDetail mapToOrderDetai(OrderDetailDto orderDetailDto){
        return new OrderDetail(
                orderDetailDto.getOrderDetailId(),
                orderDetailDto.getOrderId(),
                orderDetailDto.getProductId(),
                orderDetailDto.getPrice(),
                orderDetailDto.getQuantity(),
                orderDetailDto.getTotal()
        );
    }

}
