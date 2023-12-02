package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Khoa {
	private int idKhoa;
	private String tenKhoa;
	private ArrayList<BacSi> dsBacSi;
	
	public Khoa() {
		this.idKhoa = 0;
		this.tenKhoa = "";
		this.dsBacSi = new ArrayList<BacSi>();
	}
	public Khoa(int idKhoa, String tenKhoa, ArrayList<BacSi> dsBacSi) {
		this.idKhoa = idKhoa;
		this.tenKhoa = tenKhoa;
		this.dsBacSi = dsBacSi;
	}
	public int getIdKhoa() {
		return idKhoa;
	}
	public void setIdKhoa(int idKhoa) {
		this.idKhoa = idKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public ArrayList<BacSi> getDsBacSi() {
		return dsBacSi;
	}
	public void setDsBacSi(ArrayList<BacSi> dsBacSi) {
		this.dsBacSi = dsBacSi;
	}
	
	public String toString() {
		return "ID khoa : " + this.idKhoa +
				"\nTên khoa : " + this.tenKhoa;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID khoa : ");
		this.idKhoa = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập tên khoa : ");
		this.tenKhoa = sc.nextLine();
	}
	
	public void chinhSuaTenKhoa() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên khoa mới : ");
		this.tenKhoa = sc.nextLine();
	}
	
	public void themBacSi() {
		BacSi bacSi = new BacSi();
		System.out.println("Nhập thông tin bác sĩ muốn thêm :");
		bacSi.input();
		this.dsBacSi.add(bacSi);
		System.out.println("Đã thêm bác sĩ thành công!");
	}
	
	public void xoaBacSi() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập id bác sĩ muốn xóa: ");
		int id = Integer.parseInt(sc.nextLine());
		for(BacSi x : this.dsBacSi) {
			if(x.getIdBacSi() == id) {
				this.dsBacSi.remove(x);
				return;
			}
		}
		System.out.println("Không có bác sĩ có " + id + " trong KHOA!");
	}
	
}
