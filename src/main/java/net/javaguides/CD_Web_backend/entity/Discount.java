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
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column(name = "discountPercentage")
    private double discountPercentage;
    @Column(name = "active")
    private boolean active;
    @Column(name = "creationDate")
    private Timestamp creationDate;
    @Column(name = "startDate")
    private Timestamp startDate;
    @Column(name = "endDate")
    private Timestamp endDate;
    @Column(name = "IP")
    private String IP;

    @PrePersist
    protected void onCreate() {
        log.info("Setting create time before persisting entity");
        creationDate = new Timestamp(System.currentTimeMillis());
    }

}
