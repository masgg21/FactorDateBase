/**
 * 
 */
package com.xatu.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Administrator
 *
 */
public class CreateMySqlConnection implements CreateConnection{
	private String driver = "com.mysql.jdbc.Driver";
	private String dbName = "test";//数据库名字
	private String url = "jdbc:mysql://localhost/";//数据库地址以及名称
	private String user = "root";//数据库用户名
	private String password = "123456";//数据库用户密码
	private Connection conn;
	@Override
	public Connection createConnecton() {
		try {
			Class.forName(driver);//加载驱动程序
			conn = DriverManager.getConnection(url+dbName, user, password);
			System.out.println("链接MySql数据库成功");
			return conn;
		} 
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("链接数据库失败");
			return null;
		}
	}
}
