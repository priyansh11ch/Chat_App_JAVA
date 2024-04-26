package com.talkIT.chat_app.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.talkIT.chat_app.dto.userDTO;
import com.talkIT.chat_app.utils.encrypt;

public class user_dao {
	public static boolean is_login(userDTO userdto)
			throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select user_id from users where user_id=? and password=?";
		try {
			con = CommonDAO.createConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userdto.getUserid());
			String encrypt_pwd = encrypt.encrypt_pwd(new String(userdto.getPassword()));
			pstmt.setString(2, encrypt_pwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}

		finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public int add(userDTO userdto) throws ClassNotFoundException, SQLException, Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			con = CommonDAO.createConnection();
	    stmt = con.createStatement();
	    int record = stmt.executeUpdate("insert into users (user_id, password) values('"+userdto.getUserid()+"','"+encrypt.encrypt_pwd(new String(userdto.getPassword()))+"')");
			return 0;
		} catch (Exception e) {
			System.out.println("Errorss: " + e);
			return 0;
		}

		finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
}
