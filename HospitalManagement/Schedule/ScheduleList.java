package HospitalManagement.Schedule;
import java.util.ArrayList;

public class ScheduleList {
    private final ArrayList<Schedule> danhSach = new ArrayList<>();

    public void them(Schedule s) {
        danhSach.add(s);
        System.out.println("✔ Đã thêm đơn thuốc: " + s.getId());
    }

    public void sua(String id, String tenthuocMoi, String soluongMoi) {
        for (Schedule s : danhSach) {
            if (s.getId().equalsIgnoreCase(id)) {
                s.setTenthuoc(tenthuocMoi);
                s.setSoluong(soluongMoi);
                System.out.println("✔ Đã cập nhật đơn thuốc: " + id);
                return;
            }
        }
        System.out.println("✘ Không tìm thấy mã đơn thuốc: " + id);
    }

    public void xoa(String id) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getId().equalsIgnoreCase(id)) {
                danhSach.remove(i);
                System.out.println("✔ Đã xoá đơn thuốc: " + id);
                return;
            }
        }
        System.out.println("✘ Không tìm thấy mã đơn thuốc: " + id);
    }

    public Schedule tim(String id) {
        for (Schedule s : danhSach) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public void inTatCa() {
        for (Schedule s : danhSach) {
            System.out.println(s);
        }
    }

    public ArrayList<Schedule> getDanhSach() {
        return danhSach;
    }
}
