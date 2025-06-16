package com.example.springboot.Controller;

import com.example.springboot.Model.User;
import com.example.springboot.database.userAiven;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class userController {
    @GetMapping("/index")
    public String getuser(Model model) {
        
        // Here you can add logic to retrieve user data and add it to the model
        // For example:
        // List<User> users = userService.getAllUsers();
        // model.addAttribute("users", users);
        
        return "index"; // This will return the index.html template
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "index"; // index.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        userAiven db = new userAiven();
        ArrayList<User> users = db.getUserList();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Login success
                model.addAttribute("message", "Login success!");
                return "home"; // Chuyển sang trang home.html sau khi đăng nhập thành công
            }
        }
        // Login fail
        model.addAttribute("error", "Invalid username or password");
        return "index";
    }
}
