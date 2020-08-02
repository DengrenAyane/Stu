package com.jxau.service;

import java.sql.SQLException;
import java.util.List;

import com.jxau.domain.PageBean;
import com.jxau.domain.Student;

public interface StudentService {

	
	/**
	 * ��ѯ��ҳ������
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	PageBean findStudentByPage(int currentPage) throws SQLException ;

	/*
	 * ��ѯ����ѧ��
	 * @return List<Student>
	 */
	List<Student> findAll()  throws SQLException;
	
	/*
	 * ���ѧ��
	 * @param student ��Ҫ��ӵ����ݿ��ѧ������
	 * @throws SQLException
	 */
	void insert(Student student)  throws SQLException;
	
	/**
	 * ����idɾ��ѧ��
	 * @param id
	 * @throws SQLException
	 */
	void delete(int sid)  throws SQLException;
	
	/**
	 * ����id��ѯ����ѧ������
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid) throws SQLException;
	
	/**
	 * ����ѧ����Ϣ
	 * @param student  ��Ҫ���µ�ѧ������
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException;
	
	/**
	 * ģ����ѯ�������������߸����Ա𣬻������߼��С�
	 * @param sname
	 * @param sgender
	 * @return ����
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname,String sgender) throws SQLException;
	
}
