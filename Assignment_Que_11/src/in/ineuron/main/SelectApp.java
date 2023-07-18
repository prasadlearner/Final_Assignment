package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.util.JdbcUtil;

public class SelectApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				statement = connection.createStatement();
			}
			if (statement != null) {
				resultSet= statement.executeQuery("Select id,name,age,address from student");
		System.out.printf(" %2s  %-10s%2s %-5s","ID","Name","Age","Address");
		System.out.println();
		while(resultSet.next())
		{
			
			System.out.printf("%2d  %-10s %2d    %-5s",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4));
			System.out.println();
		}
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				JdbcUtil.cleanUp(connection, statement, resultSet);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	


}
