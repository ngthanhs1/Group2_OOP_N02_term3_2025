import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BenhAn {
    private String id;
    private String chuandoan;
    private Calendar dob;
    private String tsb;
    private String trieuchung;
    private String mbn;

    public BenhAn() {
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(dob.getTime());
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
       return "Doctor{" +
                "id='" + id + '\'' +
                ", mbn='" + mbn + '\'' +
                ", dob='" + dob + '\'' +
                ", trieuchung='" + trieuchung + '\'' +
                ", tsb='" + tsb + '\'' +
                ", chuandoan='" + chuandoan + '\'' +
                '}';
    }
    
    

}
