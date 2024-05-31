package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.DiscountDto;
import net.javaguides.CD_Web_backend.entity.Discount;
import net.javaguides.CD_Web_backend.entity.Orders;
import net.javaguides.CD_Web_backend.entity.Users;
import net.javaguides.CD_Web_backend.exception.ResourceNotFoundException;
import net.javaguides.CD_Web_backend.mapper.DiscountMapper;
import net.javaguides.CD_Web_backend.repository.DiscountRepository;
import net.javaguides.CD_Web_backend.repository.OrdersRepository;
import net.javaguides.CD_Web_backend.service.DiscountService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DiscountServiceIpml implements DiscountService {
    private DiscountRepository discountRepository;
    private OrdersRepository ordersRepository;
    @Override
    public DiscountDto createDiscount(DiscountDto discountDto) {
        Discount discount = DiscountMapper.mapToDiscount(discountDto);
        Discount saveDiscount = discountRepository.save(discount);
        return DiscountMapper.mapToDiscountDto(saveDiscount);
    }

    @Override
    public DiscountDto applyDiscount(Users userId, String code) {
        Optional<Discount> discountOptional = discountRepository.findByCode(code);
        if(discountOptional.isPresent()){
            Discount discount = discountOptional.get();
            if(isDiscountValid(discount)){
                if(!doesUserHaveDiscount(userId, discount)){
                    return DiscountMapper.mapToDiscountDto(discount);
                }else {
                    throw new ResourceNotFoundException("Discount code used");
                }
            }else {
                throw new ResourceNotFoundException("Discount code is not valid");
            }
        } else {
            throw new ResourceNotFoundException("Discount code not found");
        }
    }

    // Phương thức kiểm tra xem mã giảm giá có hợp lệ không
    private boolean isDiscountValid(Discount discount) {
        return discount.getStartDate().before(new Timestamp(System.currentTimeMillis())) &&
                discount.getEndDate().after(new Timestamp(System.currentTimeMillis()));
    }

    //kiem tra xem ma giam gia da đươc sư dung chưa
    public boolean doesUserHaveDiscount(Users userId, Discount discountId) {
        Orders order = ordersRepository.findByUserIdAndDiscountId(userId, discountId);
        return order != null;
    }
}
