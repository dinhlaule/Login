package com.luvina.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JLabel lbTaiKhoan, lbMatKhau;
	private JTextField tfTaiKhoan, tfMatKhau;
	JButton btDangNhap;

	public LoginPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
		initLoginPanel();
		addComps();
	}

	private void initLoginPanel() {
		setBackground(new Color(254, 215, 184));
		setLayout(null);
		setVisible(false);
	}

	private void addComps() {
		lbTaiKhoan = new JLabel();
		lbTaiKhoan.setText("Tài Khoản:");
		lbTaiKhoan.setBounds(300, 20, 150, 40);
		lbTaiKhoan.setForeground(new Color(105, 51, 9));
		lbTaiKhoan.setFont(new Font("Arial", Font.BOLD, 14));

		lbMatKhau = new JLabel();
		lbMatKhau.setText("Mật Khẩu:");
		lbMatKhau.setBounds(300, 100, 150, 40);
		lbMatKhau.setForeground(new Color(105, 51, 9));
		lbMatKhau.setFont(new Font("Arial", Font.BOLD, 14));

		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setBounds(480, 25, 250, 30);
		tfTaiKhoan.setForeground(Color.BLACK);
		tfTaiKhoan.setFont(new Font("Arial", Font.BOLD, 14));

		tfMatKhau = new JTextField();
		tfMatKhau.setBounds(480, 105, 250, 30);
		tfMatKhau.setForeground(Color.BLACK);
		tfMatKhau.setFont(new Font("Arial", Font.BOLD, 14));

		btDangNhap = new JButton();
		btDangNhap.setText("Đăng Nhập");
		btDangNhap.setBounds(350, 180, 350, 30);
		btDangNhap.setForeground(new Color(105, 51, 9));
		btDangNhap.setFont(new Font("Arial", Font.BOLD, 14));
		btDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String taiKhoan = tfTaiKhoan.getText();
				String matKhau = tfMatKhau.getText();
				File file = new File("E://taiKhoan.txt");
				try {
					if (!file.exists()) {
						System.out.println("File không tồn tại!");
						return;
					}
					FileInputStream fIn = new FileInputStream(file);
					String text = "";
					byte buff[] = new byte[1024];
					int length = fIn.read(buff);
					while (length > 0) {
						text += new String(buff, 0, length);
						length = fIn.read(buff);
					}
					fIn.close();

					CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
					if (e.getSource() == btDangNhap) {
						if (taiKhoan.equals(text.substring(0, text.lastIndexOf("_")))
								&& matKhau.equals(text.substring(text.lastIndexOf("_") + 1))) {
							cardLayout.show(contentPanel, "FormHS");
						} else {
							JOptionPane.showMessageDialog(btDangNhap, "Thông tin chưa chính xác, mời nhập lại!");
						}
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		add(lbTaiKhoan);
		add(lbMatKhau);
		add(tfTaiKhoan);
		add(tfMatKhau);
		add(btDangNhap);
	}
}
