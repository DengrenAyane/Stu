package com.jxau.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.domain.Student;
import com.jxau.service.StudentService;
import com.jxau.service.impl.StudentServiceImpl;

/*
 * ���ڴ���ѧ�����������
 */
public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		try {
			//1.��ȡ�ͻ����ύ����������
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			//String hobby = request.getParameter("hobby");
			String info = request.getParameter("info");
			String[] h = request.getParameterValues("hobby");
			
			//�����[...],Ҫ��������ȥ��
			String hobby=Arrays.toString(h);
			hobby=hobby.substring(1, hobby.length()-1);
			
			//2.��ӵ����ݿ�
			//string -- date
			
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sname, gender, phone, date, hobby, info);
			StudentService service = new StudentServiceImpl();
			service.insert(student);
			
			//3.��ת���б�ҳ��
			//�ٲ�һ�����ݿ⣬Ȼ����װ��������Ȼ����ת
			//������ֱ����ת��ҳ���ϣ���ô���ҳ������·���һ�Σ������Ǹ�request�������ŵ�������û����
			//request.getRequestDispatcher("list.jsp").forward(request, response);
			
			//servlet��������jsp֮�⡣������servlet
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
