package net.javaguides.CD_Web_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Slf4j
@Table(name = "orders")
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "discountId", referencedColumnName = "id")
    private Discount discountId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users userId;
    @Column(name = "payment")
    private Long payment;
    @Column(name = "ip")
    private String ip;
    @Column(name = "createTime")
    private Timestamp createTime;
    @Column(name = "orderName")
    private String orderName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "provinceId", referencedColumnName = "provinceID")
    private Provinces provinceId;
    @ManyToOne
    @JoinColumn(name = "districtId", referencedColumnName = "districtID")
    private Districts districtId;
    @Column(name = "note")
    private String note;
    @Column(name = "totalPrice")
    private double totalPrice;
    @Column(name = "transport")
    private double transport;
    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    private StatusOrder status;


    @PrePersist
    protected void onCreate() {
        log.info("Setting create time before persisting entity");
        createTime = new Timestamp(System.currentTimeMillis());
    }


}

