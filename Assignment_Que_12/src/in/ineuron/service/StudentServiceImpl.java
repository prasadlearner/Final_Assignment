package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daoFactory.StudentDaoFactory;
import in.ineuron.dto.Student;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = null;
	@Override
	public String addStudent(int id, String name, int age, String address) {
		 studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(id, name, age, address) ;
	}

	@Override
	public Student searchStudent(int id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(id) ;
	}

	@Override
	public String updateStudent(Student std) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(std);
	}

	@Override
	public String deleteStudent(int id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(id);
	}

	

	

}
