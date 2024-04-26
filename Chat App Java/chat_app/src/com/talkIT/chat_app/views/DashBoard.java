package com.talkIT.chat_app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DashBoard extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) 
//	{
//					DashBoard frame = new DashBoard();
//					frame.setVisible(true);
//	}

	/**
	 * Create the frame.
	 */
	public DashBoard(String msg) 
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 735);
		
		JMenuBar chat_menu = new JMenuBar();
		setJMenuBar(chat_menu);
		
		JMenu chats = new JMenu("Chats");
		chats.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		chat_menu.add(chats);
		
		JMenuItem start_chat = new JMenuItem("Start Chat");
		start_chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					new client_CHAT();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		chats.add(start_chat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setTitle(msg);
	}

}
