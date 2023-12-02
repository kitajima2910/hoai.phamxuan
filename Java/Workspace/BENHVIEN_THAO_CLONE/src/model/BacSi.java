package model;

import java.util.ArrayList;
import java.util.Scanner;

public class BacSi extends Person{
	private int idBacSi;
	private int idKhoaDamNhiem;
	private ArrayList<BenhNhan> dsBenhNhan;
	
	public BacSi() {
		super();
		this.idBacSi = 0;
		this.idKhoaDamNhiem = 0;
		this.dsBenhNhan = new ArrayList<BenhNhan>();
	}
	
	public BacSi(String ten, int ngaySinh, String diaChi,int idBacSi, int idKhoaDamNhiem, ArrayList<BenhNhan> dsBenhNhan) {
		super(ten, ngaySinh, diaChi);
		this.idBacSi = idBacSi;
		this.idKhoaDamNhiem = idKhoaDamNhiem;
		this.dsBenhNhan = dsBenhNhan;
	}

	public int getIdBacSi() {
		return idBacSi;
	}

	public void setIdBacSi(int idBacSi) {
		this.idBacSi = idBacSi;
	}

	public int getIdKhoaDamNhiem() {
		return idKhoaDamNhiem;
	}

	public void setIdKhoaDamNhiem(int idKhoaDamNhiem) {
		this.idKhoaDamNhiem = idKhoaDamNhiem;
	}

	public ArrayList<BenhNhan> getDsBenhNhan() {
		return dsBenhNhan;
	}

	public void setDsBenhNhan(ArrayList<BenhNhan> dsBenhNhan) {
		this.dsBenhNhan = dsBenhNhan;
	}
	
	public String toString() {
		return super.toString() +
				"ID bác sĩ : " + this.idBacSi +
				"\nID Khoa đảm nhiệm : " + this.idKhoaDamNhiem;
	}
	
	public void input() {
		Scanner sc  =new Scanner(System.in);
		super.input();
		System.out.print("Nhập ID bác sĩ : ");
		this.idBacSi = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập ID Khoa đảm nhiêm : ");
		this.idKhoaDamNhiem = Integer.parseInt(sc.nextLine());
	}
	
	public void ChinhSuThongTinBacSi() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID bác sĩ : ");
		this.idBacSi = Integer.parseInt(sc.nextLine());
	}
	
	public void doiKhoaDamNhiem() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID khoa đảm nhiệm : ");
		this.idKhoaDamNhiem = Integer.parseInt(sc.nextLine());
	}
	
}
