package com.example.springboot.Controller;

import com.example.springboot.Model.User;
import com.example.springboot.database.userAiven;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginApiController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");

        userAiven db = new userAiven();
        ArrayList<User> users = db.getUserList();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return Map.of(
                        "success", true,
                        "message", "Đăng nhập thành công",
                        "username", user.getUsername()
                );
            }
        }

        return Map.of(
                "success", false,
                "message", "Sai tài khoản hoặc mật khẩu"
        );
    }
}
