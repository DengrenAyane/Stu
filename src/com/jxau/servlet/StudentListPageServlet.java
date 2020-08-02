package com.jxau.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.domain.PageBean;
import com.jxau.service.StudentService;
import com.jxau.service.impl.StudentServiceImpl;

/**
 * �������ڷ�ҳ��ʾѧ���б��servlet
 * @author Administrator
 *
 */

public class StudentListPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1. ��ȡ��Ҫ��ʾ��ҳ����
			int currentPage =Integer.parseInt( request.getParameter("currentPage"));
			
			//2. ����ָ����ҳ����ȥ��ȡ��ҳ�����ݻ���
			//List<Student> --- list.jsp
			
			StudentService service = new StudentServiceImpl();
			PageBean pageBean= service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			//3. ��ת���档
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
