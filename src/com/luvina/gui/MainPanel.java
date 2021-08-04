package com.luvina.gui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainPanel() {
		initMainPanel();
		addComps();
	}

	public void initMainPanel() {
		setBackground(Color.PINK);
		setLayout(new CardLayout());
	}

	public void addComps() {
		LoginPanel login = new LoginPanel(this);
		add(login, "Login");
		
		FormPanel form = new FormPanel(this);
		add(form, "FormHS");
	}
}
