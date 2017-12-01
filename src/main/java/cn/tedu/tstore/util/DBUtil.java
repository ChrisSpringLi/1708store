package cn.tedu.tstore.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;




import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private static BasicDataSource dataSource;
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//读取配置文件,获取4个连接参数 conf.properties
	static{
		
		try {
			//读取resource中的配置文件
			String file="conf.properties";
			InputStream in = DBUtil.class
					.getClassLoader()
					.getResourceAsStream(file);
			Properties config=new Properties();
			config.load(in);
			driver=config.getProperty("driver");
			url=config.getProperty("url");
			username=config.getProperty("username");
			password=config.getProperty("password");
			//打桩!!!
			int max=Integer.parseInt(
					config.getProperty("MaxActive"));
			//打桩!!!
			dataSource=new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			
			dataSource.setMaxActive(max); 
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public static Connection getConnection()
		throws SQLException {
	  	Connection conn=
				dataSource.getConnection();
	  	return conn;
	}

	public static void commit(Connection conn){
		if(conn!=null){
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void rollback(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}




