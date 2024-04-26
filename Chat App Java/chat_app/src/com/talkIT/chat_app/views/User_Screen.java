package com.talkIT.chat_app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class User_Screen extends JFrame
{
	public static void main(String[] args)
	{
	   User_Screen window = new User_Screen();
	}

	/**
	 * Create the application.
	 */
	public User_Screen() {
		getContentPane().setEnabled(false);
		setResizable(false);
		setTitle("LogIn");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LogIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(241, 65, 166, 80);
		getContentPane().add(lblNewLabel);
		setBounds(100, 100, 821, 469);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
