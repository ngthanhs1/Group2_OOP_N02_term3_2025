package HospitalManagement.Test;

import HospitalManagement.Medicine.Medicine;
import HospitalManagement.Prescription.Prescription;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestPrescription {
    private Prescription prescription;

    public TestPrescription(TestMedicine tm) {
        List<Medicine> thuocChon = new ArrayList<>();

        for (Medicine m : tm.getDanhSachThuoc()) {
            thuocChon.add(m); 
        }

        this.prescription = new Prescription(
            "P001", 
            "BN001", 
            thuocChon,
            Calendar.getInstance() 
        );
    }

    public void inPrescription() {
        System.out.println("=== Thông tin đơn thuốc ===");
        System.out.println(prescription);
    }

    public Prescription getPrescription() {
        return prescription;
    }
    public void themDonThuoc() {
    System.out.println("=== Đã thêm đơn thuốc ===");
    }
    public void inDonThuoc() {
    System.out.println("=== Đã in đơn thuốc ===");
}


}
