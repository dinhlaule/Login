package com.luvina.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
	public final String PATH = "E://thongTin.txt";
	private ArrayList<Student> listStudent;

	public void initListStudent() {
		setListStudent(convertFileToTable());
	}

	public void ghiFileArr(String input, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
				System.out.println("File đã tạo thành công");
			}
			FileOutputStream fO = new FileOutputStream(file);
			byte[] byteArr = input.getBytes();
			fO.write(byteArr);
			fO.close();
		} catch (IOException e) {
			System.out.println("Lỗi, mời thực hiện lại!");
		}
	}

	public String docFileArr(String path) {
		String data = "";
		try {
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("File không tồn tại");
				return null;
			}
			FileInputStream fI = new FileInputStream(file);
			byte[] arrByte = new byte[1024];
			int length = fI.read(arrByte);
			while (length != -1) {
				data += new String(arrByte, 0, length);
				length = fI.read(arrByte);
			}
			fI.close();
		} catch (IOException e) {
			System.out.println("Lỗi, mời thực hiện lại!");
		}
		return data;
	}

	public ArrayList<Student> convertFileToTable() {
		ArrayList<Student> dataToTable = new ArrayList<Student>();
		try {
			String data = docFileArr(PATH);
			String[] arrData = data.split("\n");
			for (int i = 0; i < arrData.length; i++) {
				String[] dataInfo = arrData[i].split("_");
				Student sj = new Student(dataInfo[0], dataInfo[1], dataInfo[2]);
				dataToTable.add(sj);
			}
			return dataToTable;
		} catch (Exception e) {
			return new ArrayList<Student>();
		}
	}

	public String convertListToString(ArrayList<Student> listStudent) {
		String data = "";
		for (Student stu : listStudent) {
			data += stu;
		}
		return data;
	}

	public void themHocSinh(Student hs) {
		if (!listStudent.contains(hs)) {
			listStudent.add(hs);
		}
		String input = convertListToString(listStudent);
		ghiFileArr(input, PATH);
	}

	public ArrayList<Student> findStudent(String name) {
		listStudent = convertFileToTable();
		ArrayList<Student> dsTimKiem = new ArrayList<Student>();
		for (Student stu : listStudent) {
			if (stu.getTen().equals(name)) {
				dsTimKiem.add(stu);
			}
		}
		return dsTimKiem;
	}
	
	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}
}
