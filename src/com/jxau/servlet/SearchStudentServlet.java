package com.jxau.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.domain.Student;
import com.jxau.service.StudentService;
import com.jxau.service.impl.StudentServiceImpl;


public class SearchStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			//1. ȡ����Ҫ��ѯ�Ĺؼ����� ����  �� �Ա�
			String sname=  request.getParameter("sname");
			String sgender=  request.getParameter("sgender");
			
			//2. ��serviceȥ��ѯ
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(sname, sgender);
			
			
			System.out.println("list�Ĵ�С�ǣ�"+list.size());
			for (Student student : list) {
				System.out.println("stu="+student);
			}
			
			request.setAttribute("list", list);
			
			//3. ��ת���档�б����
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
