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


public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		try {
			//1.获取客户端提交上来的数据
			int sid=Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			
			//String hobby = request.getParameter("hobby");
			String info = request.getParameter("info");
			String[] h = request.getParameterValues("hobby");
			
			//会出现[...],要把中括号去掉
			String hobby = Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length() - 1);
			
			//2.添加到数据库
			//string -- date
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sid,sname, gender, phone, date, hobby, info);
			
			//2.更新数据库数据
			StudentService service=new StudentServiceImpl();
			service.update(student);
			
			//3.跳转界面
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
