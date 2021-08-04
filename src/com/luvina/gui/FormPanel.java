package com.luvina.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.luvina.logic.Manager;
import com.luvina.logic.Student;

public class FormPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbNhapTen, lbHoTen, lbLop, lbDiem, lbKetQuaTimKiem;
	private JTextField tfNhapTen, tfHoTen, tfLop, tfDiem;
	public JTable table;
	public static DefaultTableModel tableModel;
	private JButton btTimKiem, btNhap;
//	private IAnHien event;
	private Manager manager;
	public String[] Header;
	private JPanel contentPanel;

//	public void addEventIManager(IAnHien event) {
//		this.event = event;
//	}

	public FormPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
		initFormPanel();
		addComps();
	}

	public void initFormPanel() {
		setBackground(new Color(254, 215, 184));
		setLayout(null);
		setVisible(false);
	}

	public void addComps() {
		lbNhapTen = new JLabel();
		lbNhapTen.setText("Nhập tên học sinh");
		lbNhapTen.setBounds(20, 20, 150, 40);
		lbNhapTen.setForeground(new Color(105, 51, 9));
		lbNhapTen.setFont(new Font("Arial", Font.BOLD, 14));

		tfNhapTen = new JTextField();
		tfNhapTen.setBounds(200, 25, 400, 30);
		tfNhapTen.setForeground(Color.BLACK);
		tfNhapTen.setFont(new Font("Arial", Font.BOLD, 14));

		lbHoTen = new JLabel();
		lbHoTen.setText("Họ tên:");
		lbHoTen.setBounds(20, 100, 150, 40);
		lbHoTen.setForeground(new Color(105, 51, 9));
		lbHoTen.setFont(new Font("Arial", Font.BOLD, 14));

		tfHoTen = new JTextField();
		tfHoTen.setBounds(150, 105, 250, 30);
		tfHoTen.setForeground(Color.BLACK);
		tfHoTen.setFont(new Font("Arial", Font.BOLD, 14));

		lbLop = new JLabel();
		lbLop.setText("Lớp:");
		lbLop.setBounds(20, 180, 150, 40);
		lbLop.setForeground(new Color(105, 51, 9));
		lbLop.setFont(new Font("Arial", Font.BOLD, 14));

		tfLop = new JTextField();
		tfLop.setBounds(150, 185, 250, 30);
		tfLop.setForeground(Color.BLACK);
		tfLop.setFont(new Font("Arial", Font.BOLD, 14));

		lbDiem = new JLabel();
		lbDiem.setText("Điểm tổng kết:");
		lbDiem.setBounds(20, 260, 150, 40);
		lbDiem.setForeground(new Color(105, 51, 9));
		lbDiem.setFont(new Font("Arial", Font.BOLD, 14));

		tfDiem = new JTextField();
		tfDiem.setBounds(150, 265, 250, 30);
		tfDiem.setForeground(Color.BLACK);
		tfDiem.setFont(new Font("Arial", Font.BOLD, 14));

		btTimKiem = new JButton();
		btTimKiem.setText("Tìm kiếm");
		btTimKiem.setBounds(650, 25, 100, 30);
		btTimKiem.setForeground(new Color(105, 51, 9));
		btTimKiem.setFont(new Font("Arial", Font.BOLD, 14));

		btNhap = new JButton();
		btNhap.setText("Nhập TT HS");
		btNhap.setBounds(150, 325, 250, 30);
		btNhap.setForeground(new Color(105, 51, 9));
		btNhap.setFont(new Font("Arial", Font.BOLD, 14));

		lbKetQuaTimKiem = new JLabel();
		lbKetQuaTimKiem.setText("KẾT QUẢ TÌM KIẾM:");
		lbKetQuaTimKiem.setBounds(450, 100, 150, 40);
		lbKetQuaTimKiem.setForeground(new Color(105, 51, 9));
		lbKetQuaTimKiem.setFont(new Font("Arial", Font.BOLD, 14));

		table = new JTable();
		manager = new Manager();
		manager.initListStudent();
		Header = new String[] { "Họ tên", "Lớp", "Điểm TK" };
		updateModelTable(manager.getListStudent(), Header);
		table.setModel(tableModel);
		table.setShowGrid(true);
		table.setRowHeight(30);
		JScrollPane jc = new JScrollPane(table);
		jc = (JScrollPane) setComponent(jc, 200, 500, 400, 300);

		add(lbNhapTen);
		add(lbHoTen);
		add(lbLop);
		add(lbDiem);
		add(lbKetQuaTimKiem);
		add(tfNhapTen);
		add(tfHoTen);
		add(tfLop);
		add(tfDiem);
		add(btTimKiem);
		add(btNhap);
		add(table);
	}
	
	public static void updateModelTable(ArrayList<Student> list, String[] header) {
		String[][] arr = new String[list.size()][header.length];
		for (int i = 0; i < list.size(); i++) {
			arr[i][0] = list.get(i).getTen();
			arr[i][1] = list.get(i).getLop();
			arr[i][2] = list.get(i).getDiem();
		}
		tableModel = new DefaultTableModel(arr, header);
	}
	
	private Component setComponent(Component com, int width, int height, int x, int y) {
		com.setSize(width, height);
		com.setLocation(x, y);
		return com;
	}
	
}
