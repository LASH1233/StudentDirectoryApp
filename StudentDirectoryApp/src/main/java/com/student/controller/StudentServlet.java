package com.student.controller;
import com.student.dao.StudentDAO;
import com.student.model.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;


@WebServlet(urlPatterns = {"/add", "/students"})
public class StudentServlet extends HttpServlet {
	private StudentDAO dao;
	@Override
	public void init() {
		dao= new StudentDAO();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		try {
			System.out.println("Inside doGet()");
			List<Student>students=dao.getAllStudents();
			System.out.println("Fetched students: " + students);
			req.setAttribute("studentList", students);
			req.getRequestDispatcher("/list-student.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		try {
			System.out.println("Inside doPost()");
			Student s = new Student();
			s.setName(req.getParameter("name"));
			s.setEmail(req.getParameter("email"));
			s.setCourse(req.getParameter("course"));
			System.out.println("Student to add: " + s);
			dao.addStudent(s);
			resp.sendRedirect("students");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
