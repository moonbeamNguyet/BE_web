package net.javaguides.CD_Web_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.CD_Web_backend.entity.Category;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {
    private Long id;
    private String productName;
    private String detail;
    private double price;
    private double percentDiscount;
    private long quantity;
    private Category category;
    private Timestamp createDate;
    private Boolean status;

}
