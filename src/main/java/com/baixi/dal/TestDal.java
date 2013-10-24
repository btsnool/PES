package com.baixi.dal;

import java.awt.List;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.baixi.db.MySqlConnection;

public class TestDal {

	public List list=new List();
	public List catchName()
	{
		try {
			Statement statement= MySqlConnection.connection();
			if(statement!=null)
			{
				String sql = "select * from employee";
				String print_name = null;
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next())
				{
					print_name = rs.getString("print_name");
					print_name = new String(print_name.getBytes("ISO-8859-1"),"GB2312");
					System.out.println("姓名就是这个，从数据库得到的："+print_name);
					list.add(print_name);
				}
				 rs.close();
				 MySqlConnection.closeconnection();
				 return list;
			}	
			else
				return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
