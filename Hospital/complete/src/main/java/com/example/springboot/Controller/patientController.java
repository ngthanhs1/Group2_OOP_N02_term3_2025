// Controller: com.example.springboot.Controller.patientController.java
package com.example.springboot.Controller;

import com.example.springboot.Model.Patient;
import com.example.springboot.database.patientAiven;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class patientController {

    private final patientAiven patientDb = new patientAiven();

    @GetMapping("/patients")
    public String getPatients(Model model) {
        List<Patient> patients = patientDb.getPatientList();
        model.addAttribute("patients", patients);
        return "patients"; // Trả về file templates/patients.html
    }
}
