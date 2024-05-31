package net.javaguides.CD_Web_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.CD_Web_backend.entity.Orders;
import net.javaguides.CD_Web_backend.entity.Products;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDetailDto {
    private Long orderDetailId;
    private Orders orderId;
    private Products productId;
    private double price;
    private Long quantity;
    private double total;
}
