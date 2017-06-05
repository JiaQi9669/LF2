package com.guo.utils;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * jdbc工具类连接sql 图书馆
 * @author guo
 *
 */
public class JdbcUtil2 {
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	private static Connection conn;
	/**
	 * 静态代码块中（只加载一次）
	 */
	static{
		try {
			url="jdbc:sqlserver://172.16.8.40:1433;DatabaseName=AccessData";
			driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			user="sa";
			password="a@123456";
			//注册驱动程序
			Class.forName(driverClass);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "对不起，数据库连接错误！请填写正确的信息");
		}
	}

	/**
	 * 抽取获取连接对象的方法
	 */
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url, user, password);
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
