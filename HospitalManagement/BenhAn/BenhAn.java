package HospitalManagement.BenhAn;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BenhAn {
    private String id;
    private String chuandoan;
    private Calendar dob;
    private String tsb;
    private String trieuchung;
    private String mbn;

    public BenhAn(String id, String chuandoan, Calendar dob, String tsb, String trieuchung, String mbn) {
        this.id = id;
        this.chuandoan = chuandoan;
        this.dob = dob;
        this.tsb = tsb;
        this.trieuchung = trieuchung;
        this.mbn = mbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChuandoan() {
        return chuandoan;
    }

    public void setChuandoan(String chuandoan) {
        this.chuandoan = chuandoan;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public String getTsb() {
        return tsb;
    }

    public void setTsb(String tsb) {
        this.tsb = tsb;
    }

    public String getTrieuchung() {
        return trieuchung;
    }

    public void setTrieuchung(String trieuchung) {
        this.trieuchung = trieuchung;
    }

    public String getMbn() {
        return mbn;
    }

    public void setMbn(String mbn) {
        this.mbn = mbn;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Mã bệnh án: " + id + "\n"
                + "Mã bệnh nhân: " + mbn + "\n"
                + "Ngày lập bệnh án: " + sdf.format(dob.getTime()) + "\n"
                + "Triệu chứng: " + trieuchung + "\n"
                + "Tiền sử bệnh: " + tsb + "\n"
                + "Chẩn đoán: " + chuandoan + "\n";
    }
}
