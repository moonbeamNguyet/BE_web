package net.javaguides.CD_Web_backend.service;

import net.javaguides.CD_Web_backend.dto.DiscountDto;
import net.javaguides.CD_Web_backend.entity.Users;

public interface DiscountService {

    DiscountDto createDiscount(DiscountDto discountDto);

    DiscountDto applyDiscount(Users userId, String code);
}
