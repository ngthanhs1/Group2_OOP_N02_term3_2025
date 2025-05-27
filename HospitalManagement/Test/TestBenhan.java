package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.BenhAn.BenhanList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestBenhan {
    ArrayList<BenhAn> ds = new ArrayList<>();

    public ArrayList<BenhAn> addList() {
        BenhAn b1 = new BenhAn("BA001", "Viêm họng", new GregorianCalendar(2024, Calendar.MARCH, 15),
                "Không có", "Đau họng, sốt", "BN001");
        BenhAn b2 = new BenhAn("BA002", "Cảm cúm", new GregorianCalendar(2024, Calendar.APRIL, 20),
                "Hen suyễn", "Ho, sổ mũi", "BN002");
        BenhAn b3 = new BenhAn("BA003", "Đau dạ dày", new GregorianCalendar(2023, Calendar.NOVEMBER, 10),
                "Không có", "Đau bụng, buồn nôn", "BN003");

        ds.add(b1);
        ds.add(b2);
        ds.add(b3);
        return ds;
    }

    public void testEditDelete() {
        BenhanList benhanList = new BenhanList();
        ArrayList<BenhAn> list = addList();

        for (BenhAn ba : list) {
            benhanList.themBenhAn(ba);
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập ID bệnh án cần cập nhật: ");
            String id = sc.nextLine();

            System.out.print("Nhập chẩn đoán mới: ");
            String newCD = sc.nextLine();

            benhanList.suaBenhAn(id, newCD);
            System.out.println("\nDanh sách sau khi cập nhật:");
            benhanList.inDanhSachBenhAn();

            System.out.print("Nhập ID bệnh án cần xoá: ");
            String deleteId = sc.nextLine();

            benhanList.xoaBenhAn(deleteId);
        }

        System.out.println("\nDanh sách sau khi xoá:");
        benhanList.inDanhSachBenhAn();
    }

    public void inDanhSachBenhAn() {
        ArrayList<BenhAn> list = addList();
        for (BenhAn ba : list) {
            System.out.println(ba);
        }
    }

    public void addBenhanByInput() {
        Scanner sc = new Scanner(System.in);
        BenhanList benhanList = new BenhanList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng bệnh án muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin bệnh án thứ " + (i + 1));

            System.out.print("Mã bệnh án: ");
            String id = sc.nextLine();

            System.out.print("Mã bệnh nhân (MBN): ");
            String mbn = sc.nextLine();

            Calendar dob = null;
            while (dob == null) {
                try {
                    System.out.print("Ngày lập bệnh án (dd/MM/yyyy): ");
                    String dobStr = sc.nextLine().trim();
                    java.util.Date parsed = sdf.parse(dobStr);
                    dob = Calendar.getInstance();
                    dob.setTime(parsed);
                } catch (Exception e) {
                    System.out.println("Sai định dạng. Vui lòng nhập lại (dd/MM/yyyy).");
                }
            }

            System.out.print("Triệu chứng: ");
            String tc = sc.nextLine();

            System.out.print("Tiền sử bệnh: ");
            String tsb = sc.nextLine();

            System.out.print("Chẩn đoán: ");
            String cd = sc.nextLine();

            BenhAn ba = new BenhAn(id, cd, dob, tsb, tc, mbn);
            benhanList.themBenhAn(ba);
        }

        System.out.println("\nDanh sách bệnh án vừa nhập:");
        benhanList.inDanhSachBenhAn();
    }
}
