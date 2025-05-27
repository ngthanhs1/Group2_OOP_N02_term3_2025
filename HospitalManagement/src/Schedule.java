
import java.util.Calendar;

public class Schedule {
    private String id;
    private String benhanId;
    private String patientId;
    private Calendar date;
    private String tenthuoc;
    private String soluong;
    public Schedule() {
    }
    public Schedule(String id, String benhanId, String patientId, Calendar date, String tenthuoc, String soluong) {
        this.id = id;
        this.benhanId = benhanId;
        this.patientId = patientId;
        this.date = date;
        this.tenthuoc = tenthuoc;
        this.soluong = soluong;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBenhanId() {
        return benhanId;
    }
    public void setBenhanId(String benhanId) {
        this.benhanId = benhanId;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public Calendar getDate() {
        return date;
    }
    public void setDate(Calendar date) {
        this.date = date;
    }
    public String getTenthuoc() {
        return tenthuoc;
    }
    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }
    public String getSoluong() {
        return soluong;
    }
    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
    @Override
    public String toString() {
       return "Schedule{" +
                "id='" + id + '\'' +
                ", benhanId='" + benhanId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", date=" + getDate() +
                ", tenthuoc='" + tenthuoc + '\'' +
                ", soluong='" + soluong + '\'' +
                '}';
    }

    
}
