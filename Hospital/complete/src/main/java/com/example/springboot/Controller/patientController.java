package com.example.springboot.Controller;

import com.example.springboot.Model.Patient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/patients")
public class patientController {

    private static List<Patient> cache = new ArrayList<>();

    @GetMapping
    public List<Patient> getAllPatients() {
        return cache;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        cache.add(patient);
        return patient;
    }
}