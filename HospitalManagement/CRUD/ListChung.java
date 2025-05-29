package HospitalManagement.CRUD;

import java.util.ArrayList;

public class ListChung<T extends CoId> {
    private ArrayList<T> danhSach = new ArrayList<>();

    public void them(T obj) {
        if (timKiem(obj.getId()) != null) {
            System.out.println("ID đã tồn tại, không thể thêm.");
            return;
        }
        danhSach.add(obj);
        System.out.println("Đã thêm thành công!");
    }

    public void sua(String id, T objMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getId().equalsIgnoreCase(id)) {
                danhSach.set(i, objMoi);
                System.out.println("Đã sửa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy đối tượng có ID: " + id);
    }

    public void xoa(String id) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getId().equalsIgnoreCase(id)) {
                danhSach.remove(i);
                System.out.println("Đã xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy đối tượng có ID: " + id);
    }

    public T timKiem(String id) {
        for (T obj : danhSach) {
            if (obj.getId().equalsIgnoreCase(id)) {
                return obj;
            }
        }
        return null;
    }

    public ArrayList<T> timKiemNhieuTheoIdLienKet(String foreignKey) {
        ArrayList<T> ketQua = new ArrayList<>();
        for (T obj : danhSach) {
            if (obj.getId().equalsIgnoreCase(foreignKey)) {
                ketQua.add(obj);
            }
        }
        return ketQua;
    }

    public void inDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (T obj : danhSach) {
            System.out.println(obj);
        }
    }

    public ArrayList<T> getList() {
        return danhSach;
    }

    public boolean tonTai(String id) {
        return timKiem(id) != null;
    }
}
