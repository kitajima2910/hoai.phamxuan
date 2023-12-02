package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLy {
	private ArrayList<BenhNhan> benhNhans;
	private ArrayList<BacSi> bacSis;
	private ArrayList<Khoa> khoas;
	private ArrayList<Phong> phongs;
	
	public QuanLy() {
		this.benhNhans = new ArrayList<BenhNhan>();
		this.bacSis = new ArrayList<BacSi>();
		this.khoas = new ArrayList<Khoa>();
		this.phongs = new ArrayList<Phong>();
	}
	
	public QuanLy(ArrayList<BenhNhan> benhNhans, ArrayList<BacSi> bacSis, ArrayList<Khoa> khoas,
			ArrayList<Phong> phongs) {
		this.benhNhans = benhNhans;
		this.bacSis = bacSis;
		this.khoas = khoas;
		this.phongs = phongs;
	}
	
	public void themKhoa() {
		Khoa khoa = new Khoa();
		khoa.input();
		khoas.add(khoa);
		System.out.println("Thêm khoa thành công!");
	}
	
	public void themBacSi() {
		BacSi bacSi = new BacSi();
		bacSi.input();
		bacSis.add(bacSi);
		System.out.println("Thêm bác sĩ thành công!");
	}
	
	public void themPhong() {
		Phong phong = new Phong();
		phong.input();
		phongs.add(phong);
		System.out.println("Thêm phòng thành công!");
	}
	
	public void themBenhNhan() {
		BenhNhan benhNhan = new BenhNhan();
		benhNhan.input();
		benhNhans.add(benhNhan);
		System.out.println("Thêm bệnh nhân thành công!");
	}
	
	public void benhNhanNhapVien() {
		Scanner sc  = new Scanner(System.in);
		System.out.print("Nhập ID bệnh nhân nhập viện : ");
		int id = Integer.parseInt(sc.nextLine());
		for(BenhNhan x : this.benhNhans) {
			if(x.getIdBenhNhan() == id) {
				x.nhapVien();
				return;
			}
		}
		System.out.println("KHÔNG TÌM THẤY BỆNH NHÂN!!!");
	}
	
	public void benhNhanXuatVien() {
		Scanner sc  = new Scanner(System.in);
		System.out.print("Nhập ID bệnh nhân xuất viện : ");
		int id = Integer.parseInt(sc.nextLine());
		for(BenhNhan x : this.benhNhans) {
			if(x.getIdBenhNhan() == id) {
				x.xuatVien();
				return;
			}
		}
		System.out.println("KHÔNG TÌM THẤY BỆNH NHÂN!!!");
	}
	
	public void doiPhongChoBenhNhan() {
		Scanner sc  = new Scanner(System.in);
		System.out.print("Nhập ID bệnh nhân muốn đổi phòng : ");
		int id = Integer.parseInt(sc.nextLine());
		for(BenhNhan x : this.benhNhans) {
			if(x.getIdBenhNhan() == id) {
				System.out.print("Muốn đổi sang phòng(ID) : " );
				int idPhong  = Integer.parseInt(sc.nextLine());
				x.doiPhong(idPhong);
				return;
			}
		}
		System.out.println("KHÔNG TÌM THẤY BỆNH NHÂN!!!");
	}
	
	public void doiBacSiDamNhiem() {
		Scanner sc  = new Scanner(System.in);
		System.out.print("Nhập ID bệnh nhân muốn đổi bác sĩ đảm nhiệm : ");
		int id = Integer.parseInt(sc.nextLine());
		for(BenhNhan x : this.benhNhans) {
			if(x.getIdBenhNhan() == id) {
				System.out.print("Muốn đổi sang bác sĩ đảm nhiệm(ID) : " );
				int idBacSi  = Integer.parseInt(sc.nextLine());
				x.doiPhong(idBacSi);
				return;
			}
		}
		System.out.println("KHÔNG TÌM THẤY BỆNH NHÂN!!!");
	}

	public void danhSachBenhNhanTheoBenh() {
		System.out.println("Hiển thị danh sách bệnh nhân theo Bệnh: ");
		Scanner sc  = new Scanner(System.in);
		System.out.print("Nhập ID bệnh : ");
		int  idbenh = Integer.parseInt(sc.nextLine());
		for(BenhNhan x : this.benhNhans) {
			if(x.getIdBenh()  == idbenh) {
				System.out.println(x);
			}
		}
	}
	
	public void danhSachBenhNhanTheoPhong() {
		System.out.println("Hiển thị danh sách bệnh nhân theo Phòng");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID phòng : ");
		int  idPhong = Integer.parseInt(sc.nextLine());
		for(BenhNhan x : this.benhNhans) {
			if(x.getIdSoPhong()  == idPhong) {
				System.out.println(x);
			}
		}
	}
	
	public void danhSachBacSiTheoKhoa() {
		System.out.println("Hiển thị danh sách bác sĩ theo khoa");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID khoa : ");
		int  idKhoa = Integer.parseInt(sc.nextLine());
		for(BacSi x : bacSis) {
			if(x.getIdKhoaDamNhiem() == idKhoa) {
				System.out.println(x);
			}
		}
	}
	
	public void danhSachBenhNhanTheoNamSinh() {
		System.out.println("Hiển thị danh sách bệnh nhân theo thứ tự năm sinh");
		Collections.sort(benhNhans, new Comparator<BenhNhan>() {
			public int compare(BenhNhan x, BenhNhan y) {
				if (x.getNamSinh() < y.getNamSinh())
					return -1;
				else
					return 1;
			}
		});
		for(BenhNhan x : this.benhNhans) {
			System.out.println(x);
		}
	}
}
