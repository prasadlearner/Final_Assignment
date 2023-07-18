package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	int rowCount = 0;

	@Override
	public String addStudent(int id, String name, int age, String address) {
		
		String sql_Insert_Query = "Insert Into Student(id,name,age,address) Values(?,?,?,?)" ;
		 try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				 pstmt = connection.prepareStatement(sql_Insert_Query);
			}
			if(pstmt != null)
			{
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, address);
				int rowCount = pstmt.executeUpdate();
				System.out.println(rowCount);
				if(rowCount == 1)
				{
					return "success";
				}
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return "failure";
		
	}

	@Override
	public Student searchStudent(int id) {
		String sql_Select_Query = "SELECT * FROM student WHERE id = ?";
		
		Student student = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
		if(connection != null)
		{
			pstmt  =connection.prepareStatement(sql_Select_Query);
		}
		if(pstmt != null)
		{
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			if(resultSet != null)
			{
				if(resultSet.next())
				{
					student = new Student();
					student.setId(resultSet.getInt("id"));
					student.setName(resultSet.getString("name"));
					student.setAge(resultSet.getInt("age"));
					student.setAddress(resultSet.getString("address"));
					
					return student;
				}
			}
		}
		
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return student ;
	}

	@Override
	public String updateStudent(Student std) {
		
		String sql_Update_Query = "UPDATE student SET name=?, age=?,address=? WHERE id=?" ;
		 try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				 pstmt = connection.prepareStatement(sql_Update_Query);
			}
			if(pstmt != null)
			{
				pstmt.setString(1, std.getName());
				pstmt.setInt(2, std.getAge());
				pstmt.setString(3, std.getAddress());
				pstmt.setInt(4,std.getId());
				
				int rowCount = pstmt.executeUpdate();
				if(rowCount == 1)
				{
					return "success";
				}
				
			}
		 }
		 catch (IOException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 return "failure";

	}

	@Override
	public String deleteStudent(int id) {
		
		String sql_Delete_Query = "DELETE FROM student WHERE id = ? " ;
		 try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				 pstmt = connection.prepareStatement(sql_Delete_Query);
			}
			if(pstmt != null)
			{
				pstmt.setInt(1, id);
				
				int rowCount = pstmt.executeUpdate();

				if(rowCount == 1)
				{
					return "success";
				}
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return "failure";
		
	}


}
