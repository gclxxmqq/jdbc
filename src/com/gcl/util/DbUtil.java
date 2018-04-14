/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.gcl.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbUtil {
	private static Connection getConn() {
		Properties pro = new Properties();
		InputStream iput = DbUtil.class.getResourceAsStream("/jdbc.properties");
		try {
			pro.load(iput);
			String name = pro.getProperty("className");
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String psw = pro.getProperty("password");
			Class.forName(name);
			return DriverManager.getConnection(url, user, psw);
		} catch (IOException e) {
			System.out.println("加载文件出错");
		} catch (ClassNotFoundException e) {
			System.out.println("未找到驱动程序");
		} catch (SQLException e) {
			System.out.println("用户名或者密码或者路径错误");
		}
		return null;
	}

	private static void closeAll(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("相死都不行");
		}
	}

	public static int update(String preSQL, Object[] args) {
		Connection con = getConn();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(preSQL);
			for (int i = 0; i < args.length; ++i) {
				pst.setObject(i + 1, args[i]);
			}
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql语句有问题");
		} finally {
			closeAll(con, pst, null);
		}
		return 0;
	}

	public static <T> List<T> select(String preSQL, Class<T> cls, Object[] args) {
		List lists = new ArrayList();
		Connection con = getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(preSQL);
			for (int i = 0; i < args.length; ++i) {
				pst.setObject(i + 1, args[i]);
			}
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while (rs.next()) {
				Object t = cls.newInstance();
				for (int i = 1; i <= count; ++i) {
					String title = rsmd.getColumnName(i);
					Object value = rs.getObject(title);
					title = title.toLowerCase();
					Field ff = cls.getDeclaredField(title);
					ff.setAccessible(true);
					ff.set(t, value);
				}
				lists.add(t);
			}
		} catch (SQLException e) {
			System.out.println("sql语句有问题");
		} catch (InstantiationException e) {
			System.out.println("实例化异常(指定的Class没有无参构造方法)");
		} catch (IllegalAccessException e) {
			System.out.println("非法访问");
		} catch (NoSuchFieldException e) {
			System.out.println("没有找到指定的属性");
		} catch (SecurityException e) {
			System.out.println("出事了！");
		} finally {
			closeAll(con, pst, rs);
		}
		return ((lists.size() > 0) ? lists : null);
	}

	/*public static <T> T selectOne(String preSQL, Class<T> clas, Object id) {
		List lists = select(preSQL, clas, new Object[] { id });
		if (lists != null) {
			return lists.get(0);
		}
		return null;
	}*/

	public static int selectCount(String preSQL, Object[] args) {
		Connection con = getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int x = 0;
		try {
			pst = con.prepareStatement(preSQL);
			for (int i = 0; i < args.length; ++i) {
				pst.setObject(i + 1, args[i]);
			}
			rs = pst.executeQuery();
			while (rs.next())
				x = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("sql语句有问题");
		} finally {
			closeAll(con, pst, rs);
		}
		return x;
	}
}