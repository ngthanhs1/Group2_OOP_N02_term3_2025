package HospitalManagement.review;
import java.util.GregorianCalendar;
import java.util.Scanner;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.BenhAn.*;

import java.util.Calendar;

public class TestBenhAn {

    public static void main(String[] args) {
        TestBenhAn test = new TestBenhAn();
        test.thuChinhSuaVaXoa();
    }

    public void thuChinhSuaVaXoa() {
        // Khởi tạo bệnh án mẫu
        BenhAn ba1 = taoBenhAn("BA001", "Sốt xuất huyết", "BN001", "Sốt cao, đau đầu", "Không có tiền sử bệnh", 2000, 1, 1);
        BenhAn ba2 = taoBenhAn("BA002", "Cảm cúm", "BN002", "Ho, sổ mũi", "Hen suyễn", 1998, 5, 12);
        BenhAn ba3 = taoBenhAn("BA003", "Tiêu chảy", "BN003", "Đau bụng, đi ngoài", "Không rõ", 1995, 9, 23);

        BenhanList bal = new BenhanList();
        bal.themBenhAn(ba1);
        bal.themBenhAn(ba2);
        bal.themBenhAn(ba3);

        // Cập nhật bệnh án
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã bệnh án cần sửa:");
        String idEdit = sc.nextLine();
        System.out.println("Nhập chẩn đoán mới:");
        String cdMoi = sc.nextLine();
        bal.suaBenhAn(cdMoi, idEdit);
        System.out.println("Danh sách sau khi sửa:");
        bal.inDanhSachBenhAn();

        // Xoá bệnh án
        System.out.println("Nhập mã bệnh án cần xoá:");
        String idDel = sc.nextLine();
        bal.xoaBenhAn(idDel);
        System.out.println("Danh sách sau khi xoá:");
        bal.inDanhSachBenhAn();
    }

    public BenhAn taoBenhAn(String id, String cd, String mbn, String trieuChung, String tsb, int year, int month, int day) {
        BenhAn ba = new BenhAn();
        ba.setId(id);
        ba.setChuandoan(cd);
        ba.setMbn(mbn);
        ba.setTrieuchung(trieuChung);
        ba.setTsb(tsb);
        ba.setDob(new GregorianCalendar(year, month - 1, day));
        return ba;
    }
}
 