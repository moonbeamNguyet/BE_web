package net.javaguides.CD_Web_backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long id;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private long status;
    private long typeID;
    private String socialLoginId;
    private Timestamp createTime;
    private String IP;
}
