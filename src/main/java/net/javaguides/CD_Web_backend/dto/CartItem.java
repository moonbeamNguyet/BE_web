package net.javaguides.CD_Web_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.CD_Web_backend.entity.Products;
import net.javaguides.CD_Web_backend.entity.Users;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartItem {
    private Users user;
    private Products product;
    private int quantity;

}
