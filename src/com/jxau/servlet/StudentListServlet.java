package com.jxau.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.dao.StudentDao;
import com.jxau.domain.Student;
import com.jxau.domain.impl.StudentDaoImpl;
import com.jxau.service.StudentService;
import com.jxau.service.impl.StudentServiceImpl;

/*
 * �����ѯ����ѧ����Ϣ��Ȼ�������list.jspҳ��
 */

public class StudentListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.��ѯ�������е�ѧ��
		try {
			StudentService service=new StudentServiceImpl();
			List<Student> list = service.findAll();
			
			//2.�Ȱ����ݴ洢����������
			request.setAttribute("list", list);
			
			//3.��תҳ��
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
