package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;


@WebServlet("/search")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
IStudentService service = StudentServiceFactory.getStudentService();
		
		String sid = request.getParameter("sid");
		
		Student student = service.searchStudent(Integer.parseInt(sid));
		
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("/display.jsp");
		rd.forward(request, response);
	}

}
