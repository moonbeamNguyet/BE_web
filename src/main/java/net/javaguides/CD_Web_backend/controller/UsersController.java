package net.javaguides.CD_Web_backend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.LoginRequest;
import net.javaguides.CD_Web_backend.dto.UsersDto;
import net.javaguides.CD_Web_backend.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;


    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto){
        String ipAddress = getClientIpAddress();
        usersDto.setIP(ipAddress);
        String hashedPassword = sha256(usersDto.getPassword());
        usersDto.setPassword(hashedPassword);
        UsersDto savedUsers = usersService.createUser(usersDto);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);


    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest){
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        String hashedPassword = sha256(password);
        UsersDto usersDto = usersService.getUserByEmailAndPassWord(email, hashedPassword);
        if(usersDto != null){
            return ResponseEntity.ok(usersDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email or password is incorrect");
        }

    }






    //lay dia chi IP
    private String getClientIpAddress() {
        try {
            Socket socket = new Socket("google.com", 80); // Kết nối tạm thời đến một host bất kỳ
            InetAddress address = socket.getLocalAddress();
            return address.getHostAddress();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    // Hàm mã hóa SHA-256
    private String sha256(String password) {
        try {
            // Tạo đối tượng MessageDigest với thuật toán SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Mã hóa mật khẩu
            byte[] encodedHash = digest.digest(password.getBytes());

            // Chuyển đổi byte array thành chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Xử lý lỗi nếu thuật toán không tồn tại
            e.printStackTrace();
            return null;
        }
    }
}
