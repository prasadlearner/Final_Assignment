package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {
	
    public String addStudent(int id, String name, int age, String address);
	
	public Student searchStudent(int id);
	
	public String updateStudent(Student std);
	
	public String deleteStudent(int id);

}
