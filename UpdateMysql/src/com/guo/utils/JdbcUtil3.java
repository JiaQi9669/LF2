package com.guo.utils;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * jdbc工具类连接sql 一卡通
 * @author guo
 *
 */
public class JdbcUtil3 {
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	private static Connection conn;
	static{
		try {
//			url="jdbc:sqlserver://"+Ip.ip2+":1433;DatabaseName=AccessData";
			url="jdbc:sqlserver://172.16.8.1:1433;DatabaseName=TransDbtsg";
			driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			user="weigengread";
			password="weigeng2016";
			//注册驱动程序
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱程程序注册出错");
		}
	}

	/**
	 * 抽取获取连接对象的方法
	 */
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "对不起，数据库连接错误！请填写正确的信息");
		}
		return conn;
	}
	
	/**
	 * 释放资源的方法
	 */
	public static void close(Connection conn,Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
