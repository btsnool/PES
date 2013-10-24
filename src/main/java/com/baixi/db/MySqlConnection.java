package com.baixi.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MySqlConnection {

	private static Connection conn;
	public static Statement connection() throws ClassNotFoundException
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pes";
		String user = "root";
		String password = "";
		try {
			Class.forName(driver);
			conn =  DriverManager.getConnection(url, user, password);
			if(!conn.isClosed())      
				System.out.println("数据库连接成功!");
			Statement statement = conn.createStatement();
			return statement;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static void closeconnection()
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
