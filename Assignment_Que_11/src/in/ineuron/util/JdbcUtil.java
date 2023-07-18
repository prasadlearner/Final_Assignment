package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil() {
		
	}
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws IOException, SQLException
	{
		FileInputStream fis = new FileInputStream("D:\\FinalAssignment\\Assignment_Que_11\\src\\in\\ineuron\\properties\\application.properties");
		
		Properties p = new Properties();
		p.load(fis);
		
		Connection connection = DriverManager.getConnection(p.getProperty("url"),p.getProperty("userName"),p.getProperty("password"));
		
		return connection;
	
	}
	
	public static void cleanUp(Connection connection,Statement pstmt,ResultSet resultSet ) throws SQLException
	{
		if(connection != null)
		{
			connection.close();
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(resultSet != null)
		{
			resultSet.close();
		}
	}
	

}
