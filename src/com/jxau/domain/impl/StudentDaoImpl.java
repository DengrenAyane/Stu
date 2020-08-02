package com.jxau.domain.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jxau.dao.StudentDao;
import com.jxau.domain.Student;
import com.jxau.util.JDBCUtil02;
import com.jxau.util.TextUtils;

/*
 * ����StudentDao��ʵ�֡����ǰ�涨��Ĺ淶�����������ʵ�֡�
 */

public class StudentDaoImpl implements StudentDao {

	/*
	 * ��ѯ���е�ѧ��
	 * @throws SQLException
	 */
	
	@Override
	public List<Student> findAll() throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from stu";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		
		return list;
	}

	@Override
	public void insert(Student student) throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		runner.update("insert into stu values(null,?,?,?,?,?,?)",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
		
	}

	@Override
	public void delete(int sid) throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from stu where sid=?",sid);
		
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class),sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sname=? ,gender=? ,phone=? ,birthday=? ,hobby=? ,info=? where sid=?", 
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid()
				);
		
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

		//String sql = "select * from stu where sname=? or sgender=?";
		
		/*
		 * ����Ҫ����һ�£�
		 * 	���ֻ������ ��select * from stu where sname like ? ;
		 * 	���ֻ���Ա� �� select * from stu where gender = ?
		 * 
		 * ����������� select * from stu where sname like ? and gender=?
		 * 
		 * ���������û�оͲ�ѯ���С�
		 * 
		 */
		String sql = "select * from stu where 1=1 ";
		List<String> list = new ArrayList<String> ();
				
		//�ж���û�������� ����У�����ƴ��sql�������
		if(!TextUtils.isEmpty(sname)){
			sql = sql + "  and sname like ?";
			list.add("%"+sname+"%");
		}
		
		//�ж���û���Ա��еĻ�������ƴ��sql������档
		if(!TextUtils.isEmpty(sgender)){
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
		
		
		return runner.query(sql , new BeanListHandler<Student>(Student.class) ,list.toArray() );
		
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		//��һ���ʺţ�����һҳ���ض��ټ�¼���ڶ����ʺţ�����ǰ��Ķ��ټ�¼
		return runner.query("select * from stu limit ? offset ?", 
				new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
	
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		//���ڴ���ƽ��ֵ���ܵĸ���
		Long result = (Long) runner.query("select count(*) from stu ", new ScalarHandler());
		return result.intValue();
	}





}
