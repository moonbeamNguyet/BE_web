package net.javaguides.CD_Web_backend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.DiscountDto;
import net.javaguides.CD_Web_backend.entity.Users;
import net.javaguides.CD_Web_backend.exception.ResourceNotFoundException;
import net.javaguides.CD_Web_backend.service.DiscountService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.Socket;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    private final DiscountService discountService;


    @PostMapping
    public ResponseEntity<DiscountDto> createDiscount(@RequestBody DiscountDto discountDto){
        String ipAddress = getClientIpAddress();
        discountDto.setIP(ipAddress);

        DiscountDto saved = discountService.createDiscount(discountDto);
        return  new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/{code}")
    public ResponseEntity<?> applyDiscount(@PathVariable Users userId, @PathVariable String code) {
        try {
            DiscountDto discountDto = discountService.applyDiscount(userId, code);
            return ResponseEntity.ok(discountDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    private String getClientIpAddress() {
        try {
            Socket socket = new Socket("google.com", 80); // Kết nối tạm thời đến một host bất kỳ
            InetAddress address = socket.getLocalAddress(); // Lấy địa chỉ IP của client từ socket
            return address.getHostAddress();
        } catch (Exception e) {
            return "Unknown"; // Trả về "Unknown" nếu không thể lấy được địa chỉ IP
        }
    }
}
