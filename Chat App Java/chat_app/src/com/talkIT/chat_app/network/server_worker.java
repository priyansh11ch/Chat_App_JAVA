package com.talkIT.chat_app.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class server_worker extends Thread
{
    private Socket client_socket;
    private InputStream in;
    private OutputStream out;
    private server server;
    
    public server_worker(Socket client_socket, server server) throws IOException
    {
    	this.server = server;
    	this.client_socket = client_socket;
    	in = client_socket.getInputStream();
    	out = client_socket.getOutputStream();
    	System.out.println("New client comes");
    }
	
	@Override
	public void run()
	{
		//Read data and broadcast it
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try
		{
		      while(true)
		      {
				line = br.readLine();
				if(line.equalsIgnoreCase("quit"))
				{
					break;
				}
				//out.write(line.getBytes());
				for(server_worker obj : server.worker)
				{
					line = line+"\n";
					obj.out.write(line.getBytes());
				}
			} 
		}
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        finally
        {
        	try
        	{
        	  if(br!=null)
        	  {
        	 	br.close();
        	  }
        	  if(in!=null)
        	  {
        		in.close();
           	  }
         	  if(out!=null)
        	  {
        		out.close();
        	  }
        	  if(client_socket!=null)
        	  {
        		client_socket.close();
        	  }
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
	}
	
	public static void main(String[] args)
	{
		
	}

}
