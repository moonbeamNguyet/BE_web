package net.javaguides.CD_Web_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.CD_Web_backend.entity.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {
    private Long id;
    private Discount discountId;
    private Users userId;
    private Long payment;
    private String ip;
    private Timestamp createTime;
    private String orderName;
    private String phone;
    private String email;
    private String address;
    private Provinces provinceId;
    private Districts districtId;
    private String note;
    private double totalPrice;
    private double transport;
    private StatusOrder status;

}
