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
@Table(name = "districts")
public class Districts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtID;
    @Column(name = "districtName")
    private String districtName;
    @Column(name = "type")
    private String type;
    @Column(name = "provinceID")
    private Long provinceID;
}
