package model;

import java.util.Scanner;

public class Person {
	private String ten;
	private int namSinh;
	private String diaChi;
	public Person() {
		this.ten = "";
		this.namSinh = 0;
		this.diaChi = "";
	}
	public Person(String ten, int namSinh, String diaChi) {
		this.ten = ten;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String toString() {
		return "Tên : " + this.ten +
				"\nNăm sinh : " + this.namSinh +
				"\nĐịa chỉ : " + this.diaChi; 
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên : ");
		this.ten = sc.nextLine();
		System.out.print("Nhập năm sinh : ");
		try {
			this.namSinh = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
		}
		System.out.print("Nhập địa chỉ : ");
		this.diaChi = sc.nextLine();
	}
	
}
