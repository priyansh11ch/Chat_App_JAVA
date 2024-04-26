package com.talkIT.chat_app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encrypt 
{
	public static String encrypt_pwd(String plain_pwd) throws NoSuchAlgorithmException
  {
	  String en_pwd = null;
	  MessageDigest msg_digest = MessageDigest.getInstance("MD5");
	  msg_digest.update(plain_pwd.getBytes());
	  byte encrypted[] = msg_digest.digest();
	  en_pwd = new String(encrypted);
	  //System.out.println("encrypted pass "+en_pwd);
	  StringBuffer sb = new StringBuffer();
		 for(byte b:encrypted)
		 {
			 sb.append(b);
		 }
		 en_pwd = sb.toString();
	     return en_pwd;
  }
}
