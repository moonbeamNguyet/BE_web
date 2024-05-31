package net.javaguides.CD_Web_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Slf4j
@Table(name = "orderDetail")
public class OrderDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderDetailId;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private Orders orderId;
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Products productId;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "total")
    private double total;
}
