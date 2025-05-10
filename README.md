# HỆ THỐNG QUẢN LÝ BỆNH VIỆN

## GIỚI THIỆU DỰ ÁN
Đây là dự án quản lý Bệnh viện
## Các thành viên trong nhóm
Nguyễn Văn Thành-23010191:Phát triển phần mềm
Nguyễn Mạnh Quyền-23010198:Phát triển phần mềm

## Project : HospitalManagement

# Object: Bệnh nhân,bệnh án,bác sĩ,thuốc,...
-Bệnh nhân sẽ bao gồm tất cả thông tin liên quan đến bệnh 
Class Benhnhan{
    int patientID;
    String fullName;
    String Adress;
    String Gender;
    int Age;
    String phone;
    String email;
}

-Bệnh án sẽ bao gồm các thông tin liên quan đến các bệnh án

Class Benh_an{
    int patientID;
    int doctorID;
    int recordID;
}

-Bác sĩ sẽ bao gồm tất cả thông tin liên quan đến bác sĩ
Class Doctor{
    int doctorID;
    String fullName;
    String Adress;
    String Gender;
    int Age;
    String phone;
    String email;
}
