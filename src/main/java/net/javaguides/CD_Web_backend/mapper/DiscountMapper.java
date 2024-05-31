package net.javaguides.CD_Web_backend.mapper;

import net.javaguides.CD_Web_backend.dto.DiscountDto;
import net.javaguides.CD_Web_backend.entity.Discount;

public class DiscountMapper {
    public static DiscountDto mapToDiscountDto(Discount discount){
        return  new DiscountDto(
                discount.getId(),
                discount.getCode(),
                discount.getDiscountPercentage(),
                discount.isActive(),
                discount.getCreationDate(),
                discount.getStartDate(),
                discount.getEndDate(),
                discount.getIP()
        );
    }
    public static Discount mapToDiscount(DiscountDto discountDto){
        return new Discount(
                discountDto.getId(),
                discountDto.getCode(),
                discountDto.getDiscountPercentage(),
                discountDto.isActive(),
                discountDto.getCreationDate(),
                discountDto.getStartDate(),
                discountDto.getEndDate(),
                discountDto.getIP()

        );
    }
}
