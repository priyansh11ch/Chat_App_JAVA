package com.talkIT.chat_app.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.talkIT.chat_app.utils.configReader;

public class client 
{
	Socket socket;
	OutputStream out;
	InputStream in;
	client_worker worker;
	JTextArea textArea;
	
   public client(JTextArea textArea) throws UnknownHostException, IOException
   {
	   int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
	  socket = new Socket(configReader.getValue("SERVER_IP"),PORT); 
	  out = socket.getOutputStream();
	  in = socket.getInputStream();
	  this.textArea = textArea;
	  read_msg();
//	  System.out.println("Client connection created");
//	  System.out.println("Enter the message send to server");
//	  Scanner sc = new Scanner(System.in);
//	  String msg = sc.nextLine();
//	  OutputStream out = socket.getOutputStream();
//	  out.write(msg.getBytes());
//	  System.out.println("message sent");
//	  sc.close();
//	  out.close();
//	  socket.close();
   }
   
   public void send_msg(String msg) throws IOException
   {
	   msg = msg+"\n";
	   out.write(msg.getBytes());
   }
   
   public void read_msg()
   {
	   worker = new client_worker(in,textArea);
	   worker.start();
   }
}
