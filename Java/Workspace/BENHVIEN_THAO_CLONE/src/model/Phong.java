package model;

import java.util.Scanner;

public class Phong {
	private int idPhong;
	private String tenPhong;
	private int soLuongGiuong;
	private int soLuongBenhNhan;
	
	public Phong() {
		idPhong = 0;
		this.tenPhong = "";
		this.soLuongGiuong = 0;
		this.soLuongBenhNhan = 0;
	}
	
	public Phong(int idPhong, String tenPhong, int soLuongGiuong, int soLuongBenhNhan) {
		idPhong = idPhong;
		this.tenPhong = tenPhong;
		this.soLuongGiuong = soLuongGiuong;
		this.soLuongBenhNhan = soLuongBenhNhan;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		idPhong = idPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getSoLuongGiuong() {
		return soLuongGiuong;
	}

	public void setSoLuongGiuong(int soLuongGiuong) {
		this.soLuongGiuong = soLuongGiuong;
	}

	public int getSoLuongBenhNhan() {
		return soLuongBenhNhan;
	}

	public void setSoLuongBenhNhan(int soLuongBenhNhan) {
		this.soLuongBenhNhan = soLuongBenhNhan;
	}
	
	public String toString() {
		return "ID phòng : " + this.idPhong +
				"\nTên phòng : " + this.tenPhong + 
				"\nSố lượng giường : " + this.soLuongGiuong + 
				"\nSố lượng bệnh nhân : " + this.soLuongBenhNhan;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập id phòng : ");
		this.idPhong = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập tên phòng : ");
		this.tenPhong = sc.nextLine();
		System.out.print("Nhập số lượng giường : ");
		this.soLuongGiuong = Integer.parseInt(sc.nextLine());
	}
	
	public void chinhSuaThongTinPhong() {
		System.out.println("Nhập thông tin mới cho phòng: ");
		this.input();
	}
	
	public void themBenhNhan() {
		if(this.soLuongBenhNhan < this.soLuongGiuong) {
			this.soLuongBenhNhan++;
		}
		else {
			System.out.println("Phòng bệnh hiện đang QUÁ TẢI!");
		}
	}
	
	public void xoaBenhNhan() {
		if(this.soLuongBenhNhan == 0) {
			System.out.println("Phòng bệnh hiện không có bệnh nhân nào!");
		}
		else {
			this.soLuongBenhNhan--;
		}
	}
	
	
}
