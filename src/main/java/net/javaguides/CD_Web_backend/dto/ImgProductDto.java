package net.javaguides.CD_Web_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.CD_Web_backend.entity.Products;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImgProductDto {
    private Long id;
    private Products productID;
    private String caption;
    private String imgPath;
}
