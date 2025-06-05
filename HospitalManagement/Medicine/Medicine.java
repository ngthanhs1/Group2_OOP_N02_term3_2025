package HospitalManagement.Medicine;

import HospitalManagement.CRUD.CoId;

public class Medicine implements CoId { 
    private String id;
    private String name;
    private String dosage;
    private int timesPerDay;
    private String note;

    public Medicine(String name, String dosage, int timesPerDay, String note) {
        this.name = name;
        this.dosage = dosage;
        this.timesPerDay = timesPerDay;
        this.note = note;
        this.id = ""; 
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTenThuoc() {
        return name;
    }

    public void setTenThuoc(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(int timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-15s | %-7s | %-10d | %s", id, name, dosage, timesPerDay, note);
    }
}
