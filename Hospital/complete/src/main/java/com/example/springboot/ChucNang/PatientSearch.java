package springboot.ChucNang;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import HospitalManagement.Model.Patient;

public class PatientSearch {
    public List<Patient> searchByAnyField(List<Patient> patients, String keywordToFind){
        String lowerKeyword = keywordToFind.toLowerCase();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return patients.stream()
                .filter(p ->p.getId().toLowerCase().contains(lowerKeyword)
                     || p.getName().toLowerCase().contains(lowerKeyword)
                     || p.getAddress().toLowerCase().contains(lowerKeyword)
                     || p.getGender().toLowerCase().contains(lowerKeyword)
                     || p.getPhone().toLowerCase().contains(lowerKeyword)
                     || sdf.format(p.getDob().getTime()).contains(lowerKeyword)
                     || String.valueOf(p.getAge()).contains(lowerKeyword)
                ).collect(Collectors.toList());
    }
}
