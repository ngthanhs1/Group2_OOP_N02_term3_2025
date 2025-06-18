package com.example.springboot.Controller;

import com.example.springboot.Model.Patient;
import com.example.springboot.database.patientAiven;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/patients")
public class patientController {

    patientAiven db = new patientAiven();
    private static List<Patient> cache = new ArrayList<>();

    @GetMapping
    public List<Patient> getAllPatients() {
        if (cache.isEmpty()) {
            cache = db.getPatientList();
        }
        return cache;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        cache.add(patient);
        // TODO: Lưu vào DB nếu muốn
        return patient;
    }
}