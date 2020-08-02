package com.jxau.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.jxau.dao.StudentDao;
import com.jxau.domain.PageBean;
import com.jxau.domain.Student;
import com.jxau.domain.impl.StudentDaoImpl;
import com.jxau.service.StudentService;

/*
 * ����ѧ����ҵ��ʵ��
 */

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.insert(student);
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.delete(sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.update(student);
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		return new StudentDaoImpl().searchStudent(sname, sgender);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		
		//��װ��ҳ�ĸ�ҳ����
		PageBean<Student> pageBean = new PageBean<Student>();
		
		int pageSize = StudentDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //���õ�ǰҳ
		pageBean.setPageSize(pageSize); //����ÿҳ��ʾ���ټ�¼
		
		StudentDao dao = new StudentDaoImpl() ;
		List<Student> list =dao .findStudentByPage(currentPage);
		pageBean.setList(list); //������һҳ��ѧ������
		
		//�ܵļ�¼���� �ܵ�ҳ����
		int count = dao.findCount();
		pageBean.setTotalSize(count); //�����ܵļ�¼��
		//200 �� 10 ==20   201 �� 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //��ҳ��
		return pageBean;

	}

}
