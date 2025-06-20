package com.example.springboot.Controller;

import com.example.springboot.Model.User;
import com.example.springboot.database.userAiven;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Cho phép frontend JS truy cập từ bất kỳ domain nào
public class LoginApiController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");

        // Kiểm tra dữ liệu đầu vào không rỗng
        if (username == null || password == null) {
            return Map.of(
                "success", false,
                "message", "Thiếu tên đăng nhập hoặc mật khẩu"
            );
        }

        userAiven db = new userAiven();
        ArrayList<User> users = db.getUserList();

        // Duyệt danh sách người dùng
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                // Trả về kết quả thành công
                return Map.of(
                    "success", true,
                    "message", "Đăng nhập thành công",
                    "username", user.getUsername()
                );
            }
        }

        // Trường hợp không tìm thấy user khớp
        return Map.of(
            "success", false,
            "message", "Sai tài khoản hoặc mật khẩu"
        );
    }
}
