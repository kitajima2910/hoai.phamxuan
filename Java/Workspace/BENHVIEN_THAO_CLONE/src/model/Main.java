package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<BenhNhan> benhNhans = new ArrayList<BenhNhan>();
		ArrayList<BacSi> bacSis = new ArrayList<BacSi>();
		ArrayList<Khoa> khoas = new ArrayList<Khoa>();
		ArrayList<Phong> phongs = new ArrayList<Phong>();
		
		QuanLy quanly = new QuanLy(benhNhans, bacSis, khoas, phongs);
		
		boolean check = true;
		while(check) {
			menu();
			System.out.print("Nhập lựa chọn : ");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				quanly.themKhoa();
				break;
			case 2:
				quanly.themBacSi();
				break;
			case 3:
				quanly.themPhong();
				break;
			case 4:
				quanly.themBenhNhan();
				break;
			case 5:
				quanly.benhNhanXuatVien();
				break;
			case 6:
				quanly.benhNhanNhapVien();
				break;
			case 7:
				quanly.doiPhongChoBenhNhan();
				break;
			case 8:
				quanly.doiBacSiDamNhiem();
				break;
			case 9:
				quanly.danhSachBenhNhanTheoBenh();
				break;
			case 10:
				quanly.danhSachBenhNhanTheoPhong();
				break;
			case 11:
				quanly.danhSachBacSiTheoKhoa();
				break;
			case 12:
				quanly.danhSachBenhNhanTheoNamSinh();
				break;
			default:
				check = false;
			}
		}
		System.out.println("KẾT THÚC CHƯƠNG TRÌNH!");
		
	}
	
	public static void menu() {
		System.out.println("============================MENU==========================");
		System.out.println("| 1. Thêm khoa                                           |");
		System.out.println("| 2. Thêm Bác Sĩ                                         |");
		System.out.println("| 3. Thêm phòng                                          |");
		System.out.println("| 4. Thêm bệnh nhân                                      |");
		System.out.println("| 5. Bệnh nhân xuất viện                                 |");
		System.out.println("| 6. Bệnh nhân nhập viện                                 |");
		System.out.println("| 7. Đổi phòng cho bệnh nhân                             |");
		System.out.println("| 8. Đổi bác sĩ đảm nhiệm cho bệnh nhân                  |");
		System.out.println("| 9. Hiển thị danh sách bệnh nhân theo Bệnh              |");
		System.out.println("| 10. Hiển thị danh sách bệnh nhân theo Phòng            |");
		System.out.println("| 11. Hiển thị danh sách bác sĩ theo khoa                |");
		System.out.println("| 12. Hiển thị danh sách bệnh nhân theo thứ tự năm sinh  |");
		System.out.println("|========================================================|");
	}
}
