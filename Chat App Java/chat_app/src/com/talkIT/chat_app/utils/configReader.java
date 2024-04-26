package com.talkIT.chat_app.utils;

import java.util.ResourceBundle;

public class configReader
{
	configReader(){}
	
   private static ResourceBundle rb = ResourceBundle.getBundle("config");
   
   public static String getValue(String key)
   {
	   return rb.getString(key);
   }
}
