package com.student.dao;
import com.student.model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
	private final String URL="jdbc:mysql://127.0.0.1:3306/student_db";
	private final String USER="root";
	private final String PASSWORD="Uemkolkata1#";
	
	private Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	public List<Student> getAllStudents() throws Exception{
		List<Student>list=new ArrayList<>();
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM students");
		
		while(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("Name"));
			s.setEmail(rs.getString("email"));
			s.setCourse(rs.getString("course"));
			list.add(s);
		}
		return list;
	}
	public void addStudent(Student s)throws Exception{
		Connection conn = getConnection();
		String sql="INSERT INTO students(name,email,course) VALUES(?,?,?)";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, s.getName());
		ps.setString(2, s.getEmail());
		ps.setString(3, s.getCourse());
		ps.executeUpdate();
	}

}
