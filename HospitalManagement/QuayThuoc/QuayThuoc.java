package HospitalManagement.QuayThuoc;

import HospitalManagement.CRUD.CoId;

public class QuayThuoc implements CoId {
    private String id;
    private String tenQuay;
    private String viTri;

    public QuayThuoc(String id, String tenQuay, String viTri) {
        this.id = id;
        this.tenQuay = tenQuay;
        this.viTri = viTri;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTenQuay() {
        return tenQuay;
    }

    public void setTenQuay(String tenQuay) {
        this.tenQuay = tenQuay;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-10s | %-10s", id, tenQuay, viTri);
    }
}
