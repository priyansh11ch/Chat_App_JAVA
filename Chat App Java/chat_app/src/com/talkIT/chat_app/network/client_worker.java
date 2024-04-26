package com.talkIT.chat_app.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

public class client_worker extends Thread
{
	private InputStream in;
	private JTextArea textArea;
	
    public client_worker(InputStream in,JTextArea textArea)
    {
    	this.in = in;
    	this.textArea = textArea;
    }
	@Override
	public void run()
	{
		while(true)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			try
			{
			  while(true)
			  {
				line = br.readLine();
				textArea.setText(textArea.getText()+ line+"\n");
			  }
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(in!=null)
				{
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
