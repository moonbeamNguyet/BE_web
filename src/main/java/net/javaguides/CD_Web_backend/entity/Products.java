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
@Table(name = "products")
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "detail")
    private String detail;
    @Column(name = "price")
    private double price;
    @Column(name = "percentDiscount")
    private double percentDiscount;
    @Column(name = "quantity")
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

    @Column(name = "createDate")
    private Timestamp createDate;
    @Column(name = "status")
    private Boolean status;

    @PrePersist
    protected void onCreate() {
        log.info("Setting create time before persisting entity");
        createDate = new Timestamp(System.currentTimeMillis());
    }

}
