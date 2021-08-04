package com.luvina.gui;

import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Định nghĩa khung giao diện
	public static final int WIDTH_FRAME = 1000;
	public static final int HEIGHT_FRAME = 500;

	public GUI(String title) {
		initGUI(title);
		addEvents();
		addComps();
	}

	private void initGUI(String title) {
		setTitle(title);
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new CardLayout());
	}

	private void addEvents() {
		WindowAdapter windowAdapter = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int kq = JOptionPane.showConfirmDialog(GUI.this, "Bạn có muốn thoát khỏi chương trình không?",
						"Thông báo thoát", JOptionPane.YES_NO_OPTION);
				if (kq == JOptionPane.YES_OPTION) {
					dispose();
				}
				System.out.println("Đang thoát chương trình!");
			}

		};

		KeyAdapter keyAdapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char kyTu = e.getKeyChar();
				System.out.println(kyTu);
			}
		};

		addWindowListener(windowAdapter);
		addKeyListener(keyAdapter);

	}

	private void addComps() {
		MainPanel mainPanel = new MainPanel();
		add(mainPanel);
	}

}
