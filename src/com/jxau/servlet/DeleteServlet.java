package com.jxau.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.service.StudentService;
import com.jxau.service.impl.StudentServiceImpl;

/*
 * 用于处理删除学生
 */

public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.接收id
			int sid = Integer.parseInt(request.getParameter("sid"));
			//2.执行删除
			StudentService service = new StudentServiceImpl();
			service.delete(sid);
			//3.跳转到列表页
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
