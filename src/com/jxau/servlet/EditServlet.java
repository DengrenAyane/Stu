package com.jxau.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.domain.Student;
import com.jxau.service.StudentService;
import com.jxau.service.impl.StudentServiceImpl;

/**
 * ���Ǵ�����ѧ���ĸ��£���ѯһ��ѧ������Ϣ��Ȼ����������ҳ��
 * @author Administrator
 *
 */

public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.����id
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			//2.��ѯѧ������
			StudentService service = new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			//3.��ʾ����
			//������
			request.setAttribute("stu", stu);
			
			//��ת
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
