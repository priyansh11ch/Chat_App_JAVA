package com.talkIT.chat_app.views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.talkIT.chat_app.dao.user_dao;
import com.talkIT.chat_app.dto.userDTO;
import com.talkIT.chat_app.utils.user_info;

public class User_View extends JFrame 
{
	int counter;
	private JTextField user_id_txt;
	private JTextField pwd_txt;
	
	user_dao ud = new user_dao();
	
	private void log_in()
	{
		String user_id = user_id_txt.getText();
		   String password = pwd_txt.getText();
		   userDTO ut = new userDTO(user_id,password);
		   try 
		   {
			   String msg = "";3
			if(ud.is_login(ut))
			{
				msg = "Welcome "+user_id;
				user_info.user_name = user_id;
				JOptionPane.showMessageDialog(this, msg);
				setVisible(false);
				dispose();
				DashBoard dash_board = new DashBoard(msg);
				dash_board.setVisible(true);
			}
			else
			{
				msg = "Invalid User_id or Password";
			}
			//JOptionPane.showMessageDialog(this, msg);
		} 
		   catch (ClassNotFoundException e) 
		   {
			e.printStackTrace();
		} 
		   catch (NoSuchAlgorithmException e) 
		   {
			e.printStackTrace();
		} 
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		}
	}
	
	private void sign_up()
	{
	   String user_id = user_id_txt.getText();
	   String password = pwd_txt.getText();
	   //user_dao ud = new user_dao();
	   userDTO ut = new userDTO(user_id,password);
	   try
	   {
	     int result = ud.add(ut);
	     if(result>0)
	     {
	    	 JOptionPane.showMessageDialog(this, "Sign up successfull");
	    	 System.out.println("Record Added");
	     }
	     else
	     {
	    	 JOptionPane.showMessageDialog(this, "Sign up unsuccessfull");
	    	 System.out.println("Record not Added");
	     }
	   }
	   
	   catch(ClassNotFoundException|SQLException e)
	   {
		   System.out.println("DB Error");
		   e.printStackTrace();
	   }
	   catch(Exception e)
	   {
		   System.out.println("Some Generic exception");
		   e.printStackTrace();
	   }
	}
	
  public User_View()
  {
  	setBackground(new Color(30, 144, 255));
  	getContentPane().setBackground(new Color(135, 206, 250));
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setSize(745,432);
	  setLocationRelativeTo(null);
	  setResizable(false);
	  setTitle("LogIN");
	  
	  JLabel welcome = new JLabel("     Log in");
	  welcome.setForeground(new Color(255, 0, 0));
	  welcome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 40));
	  Container obj2 = this.getContentPane();
	  obj2.setLayout(null);
	  welcome.setBounds(250,32,200,60);
	  obj2.add(welcome);
	  
	  user_id_txt = new JTextField();
	  user_id_txt.setForeground(new Color(0, 0, 0));
	  user_id_txt.setFont(new Font("Calibri", Font.PLAIN, 12));
	  user_id_txt.setBounds(223, 143, 406, 28);
	  getContentPane().add(user_id_txt);
	  user_id_txt.setColumns(10);
	  
	  JLabel id_label = new JLabel("   User ID");
	  id_label.setForeground(new Color(255, 0, 0));
	  id_label.setBackground(new Color(255, 255, 0));
	  id_label.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
	  id_label.setBounds(105, 145, 108, 26);
	  getContentPane().add(id_label);
	  
	  JLabel pwd_label = new JLabel("  Password");
	  pwd_label.setForeground(new Color(255, 0, 0));
	  pwd_label.setBackground(new Color(255, 255, 0));
	  pwd_label.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
	  pwd_label.setBounds(105, 208, 108, 26);
	  getContentPane().add(pwd_label);
	  
	  pwd_txt = new JTextField();
	  pwd_txt.setFont(new Font("Calibri", Font.PLAIN, 12));
	  pwd_txt.setBounds(223, 209, 406, 28);
	  getContentPane().add(pwd_txt);
	  pwd_txt.setColumns(10);
	  
	  JButton login_button = new JButton("Log in");
	  login_button.setForeground(new Color(255, 0, 0));
	  login_button.setBackground(new Color(255, 255, 0));
	  login_button.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) 
	  	{
	  		log_in();
	  	}
	  });
	  login_button.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
	  login_button.setBounds(225, 294, 108, 35);
	  getContentPane().add(login_button);
	  
	  JButton sign_up_button = new JButton("Sign up");
	  sign_up_button.addActionListener(new ActionListener() {
		  @Override
	  	public void actionPerformed(ActionEvent e) 
	  	{
	  		sign_up();
	  	}
	  });
	  sign_up_button.setForeground(new Color(255, 0, 0));
	  sign_up_button.setBackground(new Color(255, 255, 0));
	  sign_up_button.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
	  sign_up_button.setBounds(433, 294, 108, 35);
	  getContentPane().add(sign_up_button);
	  
	  setVisible(true);
  }
	
  public static void main(String[] args)
  {
	  User_View obj1 = new User_View();
  }
}
