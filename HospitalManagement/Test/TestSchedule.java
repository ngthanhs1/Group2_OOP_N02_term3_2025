package HospitalManagement.Test;

import HospitalManagement.Schedule.Schedule;
import HospitalManagement.Schedule.ScheduleList;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestSchedule {
    ScheduleList list = new ScheduleList();

    public void khoiTaoMau() {
        list.them(new Schedule("DT001", "BA001", "BN001", new GregorianCalendar(2024, Calendar.NOVEMBER, 4), "thuốc A", "10"));
        list.them(new Schedule("DT002", "BA002", "BN002", new GregorianCalendar(2024, Calendar.NOVEMBER, 5), "dopamin", "1"));
        list.them(new Schedule("DT003", "BA003", "BN003", new GregorianCalendar(2024, Calendar.NOVEMBER, 6), "thuốc B", "50"));
    }

    public void hienThi() {
        list.inTatCa();
    }

    public void sua() {
        list.sua("DT002", "vitamin C", "30");
    }

    public void xoa() {
        list.xoa("DT001");
    }

    public void timKiem() {
        Schedule s = list.tim("DT003");
        if (s != null) {
            System.out.println("✔ Tìm thấy: " + s);
        } else {
            System.out.println("✘ Không tìm thấy đơn thuốc.");
        }
    }
}
