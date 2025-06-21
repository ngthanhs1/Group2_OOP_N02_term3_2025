package com.example.servingwebcontent;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
    @Controller
public class BenhnhanController {




 //   private final benhanAiven benhanDb = new benhanAiven();

    @GetMapping("/patients")
    public String getBenhAn(Model model) {
       // List<BenhAn> benhans = benhanDb.getBenhanList();
     ///   model.addAttribute("benhanList", benhans);
        return "patients"; // Trả về file templates/benhan.html
    }
}
    
