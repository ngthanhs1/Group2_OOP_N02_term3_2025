package com.example.springboot.Controller;

import com.example.springboot.Model.BenhAn;
import com.example.springboot.database.benhanAiven;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BenhanController {

    private final benhanAiven benhanDb = new benhanAiven();

    @GetMapping("/benhan")
    public String getBenhAn(Model model) {
        List<BenhAn> benhans = benhanDb.getBenhanList();
        model.addAttribute("benhanList", benhans);
        return "benhan"; // Trả về file templates/benhan.html
    }
}