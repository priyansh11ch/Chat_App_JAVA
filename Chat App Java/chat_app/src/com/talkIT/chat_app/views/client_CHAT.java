package com.talkIT.chat_app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.talkIT.chat_app.network.client;
import com.talkIT.chat_app.utils.user_info;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class client_CHAT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextArea textArea;
	client cl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					try {
						client_CHAT frame = new client_CHAT();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	
	private void sendIT()
	{
		String msg = textField_1.getText();
		try {
			cl.send_msg(user_info.user_name+" - "+msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public client_CHAT() throws UnknownHostException, IOException 
	{
		textArea = new JTextArea();
		cl = new client(textArea);
		setTitle("Chat Screen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 28, 595, 441);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Calibri", Font.BOLD, 18));
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(23,45,523,400);
		scrollPane.setViewportView(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(0, 0, 0));
		textField_1.setForeground(Color.BLUE);
		textField_1.setFont(new Font("Calibri", Font.BOLD, 15));
		textField_1.setBounds(23, 480, 513, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton sendIT = new JButton("SEND");
		sendIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sendIT();
			}
		});
		sendIT.setBackground(Color.YELLOW);
		sendIT.setForeground(Color.RED);
		sendIT.setFont(new Font("Georgia Pro", Font.BOLD, 12));
		sendIT.setBounds(546, 480, 72, 31);
		contentPane.add(sendIT);
		setVisible(true);
	}
}
