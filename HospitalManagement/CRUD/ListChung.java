package HospitalManagement.CRUD;

import java.util.ArrayList;

import HospitalManagement.Patientt.Patient;

public class ListChung<T extends CoId> {
    private ArrayList<T> danhSach = new ArrayList<>();

    public void them(T obj) {
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

    public void inDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (T obj : danhSach) {
            System.out.println(obj);
        }
    }

    public ArrayList<T> getDanhSach() {
        return danhSach;
    }

    public void add(Patient p) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    public void printAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printAll'");
    }

    public void delete(String deleteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Patient findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }
}
