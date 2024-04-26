package com.talkIT.chat_app.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.talkIT.chat_app.utils.configReader;

public class server 
{
  ServerSocket server_socket;
  ArrayList<server_worker> worker = new ArrayList<>();
  
  public server() throws IOException
  {
	  int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
	  server_socket = new ServerSocket(PORT);
	  System.out.println("Server Starts.....");
	  handle_request();
  }
  
  public void handle_request() throws IOException
  {
	  while(true)
	  {
	    Socket client_socket = server_socket.accept();
	    server_worker obj = new server_worker(client_socket,this);
	    worker.add(obj);
	    obj.start();
	  } 
  }
  
  //For single client
  /*public server() throws IOException
  {
	  int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
	  server_socket = new ServerSocket(PORT);
	  System.out.println("Server started and waiting for Client");
	  Socket socket = server_socket.accept();
	  System.out.println("Client connected");
	  InputStream in = socket.getInputStream();
	  byte a[] = in.readAllBytes();
	  String st = new String(a);
	  System.out.println("message received: "+st);
	  in.close();
	  socket.close();
  }*/
  
  public static void main(String[] args) throws IOException
  {
	  server obj = new server();
  }
}
