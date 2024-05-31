package net.javaguides.CD_Web_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.OrderDetailDto;
import net.javaguides.CD_Web_backend.entity.Orders;
import net.javaguides.CD_Web_backend.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetailDto> createOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
        OrderDetailDto savedOrderDetail = orderDetailService.createOrderDetail(orderDetailDto);
        return new ResponseEntity<>(savedOrderDetail, HttpStatus.CREATED);
    }
    @GetMapping("{userId}/{orderId}")
    public ResponseEntity<List<OrderDetailDto>> getAllImageByOrderId(
            @PathVariable("userId") Long userId,
            @PathVariable("orderId") Orders orderId) {
        List<OrderDetailDto> orderDetailDtos = orderDetailService.getAllOrderId(userId, orderId);
        return ResponseEntity.ok(orderDetailDtos);
    }
}
