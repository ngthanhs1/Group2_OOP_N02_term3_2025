package com.example.springboot.Controller;

import com.example.springboot.Model.Room;
import com.example.springboot.database.roomAiven;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoomController {

    private final roomAiven roomDb = new roomAiven();

    @GetMapping("/rooms")
    public String getRooms(Model model) {
        List<Room> rooms = roomDb.getRoomList();
        model.addAttribute("roomList", rooms);
        return "phongdieutri"; // Trả về file templates/phongdieutri.html
    }
}