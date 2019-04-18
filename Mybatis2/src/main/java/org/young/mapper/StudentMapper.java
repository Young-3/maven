package org.young.mapper;

import org.young.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Young
 * @version1.0
 */

//操作mybatis的接口
public interface StudentMapper {
	//约定
	//方法名与mapper.xml中的id值一致
	//方法的输入参数和mapper.xml中的parameterType一致
	//方法的输出参数和mapper.xml中的resultType一致

	public abstract Student queryStudentByStuId(int stuId);
	//返回值没有resultType，就为void
	void addStudent(Student student);
	void updateStudentByStuIdAndStuPw(Student student);
	void deleteStudentByStuId(int stuId);
	List<Student> queryAllStudents();
	Student queryStudentByStuIdWithConverter(int stuId);
	Student queryStudentByIdAndPw(Student student);
	List<Student> queryStudentByAddress(Address address);
	List<Student> queryStudentByStuAddress(Student address );
	Student queryStudentByIdAndPwWithMap(Map<String,Object> map);
	void queryCountByGnameWithProcedure(Map<String,Object> params);
	List<HashMap<String,Object>> queryAllStudentByMapKey();
	List<Student> queryStudentSqlTap(Student student);
	List<Student> queryStuWithNosInGrade(Grade grade);
	List<Student> queryStuWithArray(int[] stuIds);
	List<Student> queryStuWithList(List<Integer> list);
	List<Student> queryStuWithObjectAray(Object[] objects);
	StudentBusiness queryStuByIdWithOne(int stuId);
	Student queryStuByIdWithOne1(int stuId);
	StudentClass queryStusAClaByClaId(int classId);

}
