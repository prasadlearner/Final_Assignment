package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	
	public String addStudent(int id, String name, int age, String address);
	
	public Student searchStudent(int id);
	
	public String updateStudent(Student std);
	
	public String deleteStudent(int id);


}
