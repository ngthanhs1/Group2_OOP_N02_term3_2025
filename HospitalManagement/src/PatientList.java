
import java.util.ArrayList;

public class PatientList {
    ArrayList<Patient> patients = new ArrayList<>();

    
    public void addPatient(Patient p) {
        patients.add(p);
        System.out.println("Đã thêm bệnh nhân.");
    }

    public void editPatient(String id, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.set(i, updatedPatient);
                System.out.println("Đã cập nhật thông tin.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân có ID: " + id);
    }

    public void deletePatient(String id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.remove(i);
                System.out.println("Đã xóa bệnh nhân.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân có ID: " + id);
    }

    public void printPatientList() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách bệnh nhân trống.");
        } else {
            System.out.println("Danh sách bệnh nhân:");
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
     public ArrayList<Patient> getPatients() {
            return patients;
        }

}
