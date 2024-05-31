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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "passWord")
    private String password;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email" , nullable = false, unique = true)
    private String email;
    @Column(name = "status")
    private long status;
    @Column(name = "typeID")
    private long typeID;
    @Column(name = "socialLoginId")
    private String socialLoginId;
    @Column(name = "CreateTime")
    private Timestamp createTime;
    @Column(name = "IP")
    private String IP;


    @PrePersist
    protected void onCreate() {
        log.info("Setting create time before persisting entity");
        createTime = new Timestamp(System.currentTimeMillis());
    }
}
