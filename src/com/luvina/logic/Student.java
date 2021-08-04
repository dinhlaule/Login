package com.luvina.logic;

public class Student {
	private String ten;
	private String lop;
	private String diem;

	public Student(String ten, String lop, String diem) {
		this.ten = ten;
		this.lop = lop;
		this.diem = diem;
	}

	@Override
	public String toString() {
		return this.ten + "_" + this.lop + "_" + this.diem + "\n";
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}
	
}
