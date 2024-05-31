package net.javaguides.CD_Web_backend.controller;

import net.javaguides.CD_Web_backend.dto.AddToCartRequest;
import net.javaguides.CD_Web_backend.dto.CartItem;
import net.javaguides.CD_Web_backend.entity.Products;
import net.javaguides.CD_Web_backend.entity.Users;
import net.javaguides.CD_Web_backend.repository.ProductsRepository;
import net.javaguides.CD_Web_backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cart")

public class CartController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductsRepository productsRepository;
    private List<CartItem> cart = new ArrayList<>();


    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody AddToCartRequest request) {
        Long userId = request.getUser().getId();
        Users user = usersRepository.findById(userId).orElse(null);
        Long productId = request.getProduct().getId();
        Products product = productsRepository.findById(productId).orElse(null);
        int quantity = request.getQuantity();
        if (user == null || product == null) {
            return ResponseEntity.badRequest().body("User ID and Product ID are required");
        }
        for (CartItem item : cart) {
            if (item.getUser().getId().equals(userId) && item.getProduct().getId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                return ResponseEntity.ok("Product has been updated in the cart");
            }
        }
        CartItem newItem = new CartItem();
        newItem.setUser(user);
        newItem.setProduct(product);
        newItem.setQuantity(quantity);
        cart.add(newItem);
        return ResponseEntity.ok("Product has been added to the cart");
    }

    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getCartItems() {
        return ResponseEntity.ok(cart);
    }

@GetMapping("/items/{id}")
public ResponseEntity<List<CartItem>> getCartItems(@PathVariable("id") Long userId) {

    List<CartItem> userCartItems = new ArrayList<>();

    for (CartItem item : cart) {
        if (item.getUser().getId().equals(userId)) {
            userCartItems.add(item);
        }
    }
    return ResponseEntity.ok(userCartItems);
}

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart() {
        cart.clear();
        return ResponseEntity.ok("Cart has been cleared");
    }

    @DeleteMapping("/clear/{productId}/{userId}")
    public ResponseEntity<String> clearCartItem(@PathVariable Long productId, @PathVariable Long userId) {
        cart.removeIf(cartItem -> cartItem.getProduct().getId().equals(productId) && cartItem.getUser().getId().equals(userId));
        return ResponseEntity.ok("Product has been removed from the cart");
    }

    @DeleteMapping("/clear/user/{userID}")
    public ResponseEntity<String> clearCartByUserID(@PathVariable Long userID) {
        // Xóa các mục trong giỏ hàng dựa trên user
        cart.removeIf(cartItem -> cartItem.getUser().getId() != null && cartItem.getUser().getId().equals(userID));
        return ResponseEntity.ok("Giỏ hàng của người dùng có ID " + userID + " đã được xóa");
    }

}

