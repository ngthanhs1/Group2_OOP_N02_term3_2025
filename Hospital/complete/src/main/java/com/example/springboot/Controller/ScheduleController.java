package com.example.springboot.Controller;

import com.example.springboot.Model.Schedule;
import com.example.springboot.database.scheduleAiven;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ScheduleController {

    private final scheduleAiven scheduleDb = new scheduleAiven();

    @GetMapping("/schedules")
    public String getSchedules(Model model) {
        List<Schedule> schedules = scheduleDb.getScheduleList();
        model.addAttribute("scheduleList", schedules);
        return "lichcapthuoc"; // Trả về file templates/lichcapthuoc.html
    }
}