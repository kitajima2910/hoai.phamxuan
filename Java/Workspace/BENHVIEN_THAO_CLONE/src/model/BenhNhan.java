package model;

import java.util.Scanner;

public class BenhNhan extends Person{
	private int idBenhNhan;
	private int idBenh;
	private int idSoPhong;
	private String ngayNhapVien;
	private String ngayXuatVien;
	private int idBacSiDamNhiem;
	
	public BenhNhan() {
		super();
		this.idBenhNhan = 0;
		this.idBenh = 0;
		this.idSoPhong = 0;
		this.ngayNhapVien = "";
		this.ngayXuatVien = "";
		this.idBacSiDamNhiem = 0;
	}

	public BenhNhan(String ten, int ngaySinh, String diaChi, int idBenhNhan, int idBenh, int idSoPhong, String ngayNhapVien, String ngayXuatVien,
		 int idBacSiDamNhiem) {
		super(ten, ngaySinh, diaChi);
		this.idBenhNhan = idBenhNhan;
		this.idBenh = idBenh;
		this.idSoPhong = idSoPhong;
		this.ngayNhapVien = ngayNhapVien;
		this.ngayXuatVien = ngayXuatVien;
		this.idBacSiDamNhiem = idBacSiDamNhiem;
	}

	public int getIdBenhNhan() {
		return idBenhNhan;
	}

	public void setIdBenhNhan(int idBenhNhan) {
		this.idBenhNhan = idBenhNhan;
	}

	public int getIdBenh() {
		return idBenh;
	}

	public void setIdBenh(int idBenh) {
		this.idBenh = idBenh;
	}

	public int getIdSoPhong() {
		return idSoPhong;
	}

	public void setIdSoPhong(int idSoPhong) {
		this.idSoPhong = idSoPhong;
	}

	public String getNgayNhapVien() {
		return ngayNhapVien;
	}

	public void setNgayNhapVien(String ngayNhapVien) {
		this.ngayNhapVien = ngayNhapVien;
	}

	public String getNgayXuatVien() {
		return ngayXuatVien;
	}

	public void setNgayXuatVien(String ngayXuatVien) {
		this.ngayXuatVien = ngayXuatVien;
	}

	public int getIdBacSiDamNhiem() {
		return idBacSiDamNhiem;
	}

	public void setIdBacSiDamNhiem(int idBacSiDamNhiem) {
		this.idBacSiDamNhiem = idBacSiDamNhiem;
	}
	
	public String toString() {
		return super.toString() +
				"\nID bệnh nhân : " + this.idBenhNhan +
				"\nID bệnh : " + this.idBenh +
				"\nID số phòng : " + this.idSoPhong + 
				"\nNgày nhập viện :" + this.ngayNhapVien +
				"\nNgày xuất viện : " + this.ngayXuatVien +
				"\nID Bác sĩ đảm nhiệm : " + this.idBacSiDamNhiem;
	}
	
	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID bệnh nhân : ");
		this.idBenhNhan = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập ID bệnh : ");
		this.idBenh = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập ID số phòng : ");
		this.idSoPhong = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập ID bác sĩ đảm nhiệm : ");
		this.idBacSiDamNhiem = Integer.parseInt(sc.nextLine());
	}
	
	public void xuatVien() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ngày xuất viện : ");
		this.ngayXuatVien = sc.nextLine();
	}
	
	public void nhapVien() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ngày nhập viện : ");
		this.ngayNhapVien = sc.nextLine();
	}
	
	public void thayDoiBacSiDamNhiem(int idBacSiDamNhiem) {
		this.idBacSiDamNhiem = idBacSiDamNhiem;
	}
	
	public void doiPhong(int idSoPhong) {
		this.idSoPhong = idSoPhong;
	}
}
