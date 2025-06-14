package springboot.CRUD;
// package HospitalManagement.Patientt;

// import java.util.ArrayList;

// public class PatientList {
//     private ArrayList<Patient> list = new ArrayList<>();

//     public void addPatient(Patient p) {
//         list.add(p);
//     }

//     public void editPatient(String id, String newName) {
//         for (Patient p : list) {
//             if (p.getId().equalsIgnoreCase(id)) {
//                 p.setName(newName);
//                 System.out.println("Đã cập nhật tên cho bệnh nhân có ID: " + id);
//                 return;
//             }
//         }
//         System.out.println("Không tìm thấy bệnh nhân với ID: " + id);
//     }

//     public void deletePatient(String id) {
//         list.removeIf(p -> p.getId().equalsIgnoreCase(id));
//         System.out.println("Đã xoá bệnh nhân có ID: " + id);
//     }

//     public void printPatientList() {
//         if (list.isEmpty()) {
//             System.out.println("Danh sách bệnh nhân trống.");
//         } else {
//             for (Patient p : list) {
//                 System.out.println(p);
//             }
//         }
//     }
// }
