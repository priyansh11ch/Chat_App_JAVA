package com.talkIT.chat_app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.talkIT.chat_app.utils.configReader.getValue;

public class CommonDAO 
{
   public static Connection createConnection() throws ClassNotFoundException, SQLException
   {
	   Class.forName(getValue("DRIVER"));
	   
	   final String connection = getValue("CONNECTION_URL");
	   final String USER_ID = getValue("USERID");
	   final String PASSWORD = getValue("PASSWORD");
	   
	   Connection con = DriverManager.getConnection(connection,USER_ID,PASSWORD);
	   
	   if(con!=null) {
		   System.out.println("Connection Created");
	   }
	   return con;
   }
}
